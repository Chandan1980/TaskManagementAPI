package nz.co.solnet.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import nz.co.solnet.exception.dto.ExceptionResponse;
import nz.co.solnet.exception.dto.SevereException;
import nz.co.solnet.exception.dto.TaskNotFoundException;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object> handleExceptions( TaskNotFoundException exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }
	
	@ExceptionHandler(SevereException.class)
    public ResponseEntity<Object> handleExceptions( SevereException exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Server side error");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

}
