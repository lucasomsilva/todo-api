package project.todo.todo_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.todo.todo_api.dto.TaskCreateDTO;
import project.todo.todo_api.dto.TaskResponseDTO;
import project.todo.todo_api.dto.TaskUpdateDTO;
import project.todo.todo_api.persistence.entity.Task;
import project.todo.todo_api.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(
            @Valid
            @RequestBody TaskCreateDTO taskCreateDTO
    ) {
        TaskResponseDTO createdTask = service.createTask(taskCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = service.getTasks();
        return ResponseEntity.status(200).body(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @Valid
            @PathVariable Integer id,
            @RequestBody TaskUpdateDTO taskUpdateDTO) {

        Task taskUpdated = service.updateTask(taskUpdateDTO, id);
        return ResponseEntity.ok(taskUpdated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Integer id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
