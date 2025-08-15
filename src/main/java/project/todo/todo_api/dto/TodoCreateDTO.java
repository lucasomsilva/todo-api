package project.todo.todo_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoCreateDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private LocalDate createdAt;
}
