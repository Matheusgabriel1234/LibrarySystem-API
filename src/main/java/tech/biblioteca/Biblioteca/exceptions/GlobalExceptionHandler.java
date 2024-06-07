package tech.biblioteca.Biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(ObjectNotFound.class)
public ResponseEntity<?> handleObjectNotFoundException(ObjectNotFound ex,WebRequest req){
	ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND.value(),ex.getMessage(),req.getDescription(false));
	return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
}
	
	
	
	
	
}
