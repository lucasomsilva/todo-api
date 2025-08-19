package project.todo.todo_api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    public static void main(String[] args) {

        String connectionUrl =
                "jdbc:sqlserver://todo-api.database.windows.net:1433;"
                        + "database=TodoListDB;"
                        + "user=springuser@todo-api;"
                        + "password=API-todo2025"
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
