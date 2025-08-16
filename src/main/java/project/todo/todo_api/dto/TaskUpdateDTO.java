package project.todo.todo_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.todo.todo_api.enums.Status;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private Status status;
    private LocalDateTime updatedAt;
}
