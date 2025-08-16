package project.todo.todo_api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todo.todo_api.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
