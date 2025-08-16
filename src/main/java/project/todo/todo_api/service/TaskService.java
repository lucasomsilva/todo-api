package project.todo.todo_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.todo.todo_api.dto.TaskCreateDTO;
import project.todo.todo_api.dto.TaskResponseDTO;
import project.todo.todo_api.dto.TaskUpdateDTO;
import project.todo.todo_api.enums.Status;
import project.todo.todo_api.exception.BadRequestException;
import project.todo.todo_api.exception.EmptyListException;
import project.todo.todo_api.exception.TaskNotFoundException;
import project.todo.todo_api.persistence.entity.Task;
import project.todo.todo_api.persistence.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public TaskResponseDTO createTask(TaskCreateDTO taskCreateDTO) {
        if (taskCreateDTO.getTitulo() == null || taskCreateDTO.getTitulo().isBlank())
            throw new BadRequestException("O campo 'título' é obrigatório");

        if (taskCreateDTO.getDescricao() == null || taskCreateDTO.getDescricao().isBlank())
            throw new BadRequestException("O campo 'descrição' é obrigatório!");

        Task task = new Task();

        task.setTitulo(taskCreateDTO.getTitulo());
        task.setDescricao(taskCreateDTO.getDescricao());
        task.setStatus(Status.PENDENTE);
        task.setCreatedAt(LocalDateTime.now());

        Task savedTask = repository.save(task);
        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitulo(),
                savedTask.getDescricao(),
                savedTask.getStatus(),
                savedTask.getCreatedAt()
        );
    }

    public List<Task> getTasks() {
        List<Task> tasks = repository.findAll();
        if (tasks.isEmpty()) throw new EmptyListException("A lista de tarefas está vazia");
        return tasks;
    }

    public Task updateTask(TaskUpdateDTO taskUpdateDTO, Integer id) {
        Task taskToUpdate = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task com o id " + id + " não encontrada para atualizar"));

        if (taskUpdateDTO.getStatus() == null) {
            taskUpdateDTO.setStatus(Status.PENDENTE);
        } else {
            taskToUpdate.setStatus(taskUpdateDTO.getStatus());
        }

        if (taskUpdateDTO.getTitulo() == null || taskUpdateDTO.getTitulo().isBlank()) {
            taskUpdateDTO.setTitulo(taskToUpdate.getTitulo());
        } else {
            taskToUpdate.setTitulo(taskUpdateDTO.getTitulo());
        }

        if (taskUpdateDTO.getDescricao() == null || taskUpdateDTO.getDescricao().isBlank()) {
            taskUpdateDTO.setDescricao(taskToUpdate.getDescricao());
        } else {
            taskToUpdate.setDescricao(taskUpdateDTO.getDescricao());
        }

        taskToUpdate.setUpdatedAt(LocalDateTime.now());
        repository.save(taskToUpdate);

        return taskToUpdate;
    }

    public void deleteTask(Integer id) {
        boolean taskToDelete = repository.existsById(id);

        if (!taskToDelete) {
            throw new TaskNotFoundException("Task com id " + id + " não encontrada para remover");
        } else {
            repository.deleteById(id);
        }
    }

}
