package project.todo.todo_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDTO {

    @NotBlank(message = "O campo 'título' é obrigatório!")
    private String titulo;

    @NotBlank(message = "O campo 'descrição' é obrigatório!")
    private String descricao;
    private LocalDateTime createdAt;
}
