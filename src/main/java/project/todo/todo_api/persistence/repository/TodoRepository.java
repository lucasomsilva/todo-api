package project.todo.todo_api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todo.todo_api.persistence.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
