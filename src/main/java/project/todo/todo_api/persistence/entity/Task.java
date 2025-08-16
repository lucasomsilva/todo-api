package project.todo.todo_api.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.todo.todo_api.enums.Status;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", columnDefinition = "VARCHAR(50)")
    private String titulo;

    @Column(name = "descricao", columnDefinition = "LONGTEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

}