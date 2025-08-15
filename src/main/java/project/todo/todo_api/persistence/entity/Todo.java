package project.todo.todo_api.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.todo.todo_api.enums.Status;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", columnDefinition = "VARCHAR(20)")
    private String titulo;

    @Column(name = "descricao", columnDefinition = "LONGTEXT")
    private String descricao;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP")
    private LocalDate updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;
}