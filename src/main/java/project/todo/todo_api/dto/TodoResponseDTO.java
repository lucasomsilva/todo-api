package project.todo.todo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.todo.todo_api.enums.Status;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponseDTO {
    private int id;
    private String titulo;
    private String descricao;
    private Status status;
}
