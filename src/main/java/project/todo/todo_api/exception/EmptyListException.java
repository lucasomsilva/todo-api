package project.todo.todo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyListException extends RuntimeException {

    public EmptyListException(String message) {
        super(message);
    }
}
