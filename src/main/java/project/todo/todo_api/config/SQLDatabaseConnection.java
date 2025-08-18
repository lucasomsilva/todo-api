package project.todo.todo_api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    public static void main(String[] args) {

        String user = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        String connectionUrl =
                "jdbc:sqlserver://todo-api.database.windows.net:1433;"
                        + "database=TodoListDB;"
                        + "user=" + user + ";"
                        + "password=" + password + ";"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            System.out.println("Conectado ao banco de dados com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Falha na conexão com o banco de dados", e);
        }

    }

}
