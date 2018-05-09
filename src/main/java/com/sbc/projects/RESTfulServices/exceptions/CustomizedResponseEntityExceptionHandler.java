package com.sbc.projects.RESTfulServices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * @param This ExceptionHandler class will handle any exceptions including custom exceptions from any @Controller 
 * It uses CustomResponseMessage Object to respond to the exceptions
 * @return 
 * @ExceptionHandler(UserNotFoundException.class) will return status: NOT_FOUND, CustomResponseMessage Object as response
 * @ExceptionHandler(Exception.class) will return status: INTERNAL_SERVER_ERROR, CustomResponseMessage Object as response
 */


@ControllerAdvice		// ExceptionHandler handles any exceptions from all the Controllers
@RestController     // to send a Exception Response
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	// @Exception Handler(Exception.class) will handle all exceptions and will return custom message from 
	// 'CustomResponseMessage.java' Class with Status: 500_INTERNAL_SERVER_ERROR
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		
		CustomResponseMessage customResponseMessage = new CustomResponseMessage
				(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(customResponseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// @Exception Handler(UserNotFoundException.class) will handle only UserNotFoundExceptions and will return 
	// custom message from 'CustomResponseMessage.java' Class with customized Status: NOT_FOUND
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException ex, WebRequest request) {
		
		CustomResponseMessage customResponseMessage = new CustomResponseMessage
				(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(customResponseMessage, HttpStatus.NOT_FOUND);
	}
	
	
	// @Exception Handler(UserNotFoundException.class) will handle only UserNotFoundExceptions and will return 
	// custom message from 'CustomResponseMessage.java' Class with customized Status: NOT_FOUND
	
	@ExceptionHandler(DeleteUserException.class)
	public final ResponseEntity<Object> handleAllExceptions(DeleteUserException ex, WebRequest request) {
		
		CustomResponseMessage customResponseMessage = new CustomResponseMessage
				(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(customResponseMessage, HttpStatus.NOT_FOUND);
	}
	
	
	
	// Add @Valid with the input parameter in MainController and add @NotNull, @ Min, @ Past in model Class.
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomResponseMessage customResponseMessage = new CustomResponseMessage
				(new Date(), "VALIDATION_FAILED", ex.getBindingResult().toString());
		
		return new ResponseEntity(customResponseMessage, HttpStatus.BAD_REQUEST);	// Response status: 400 BAD_REQUEST
	}
	
	
	
	
	
	
	
	
	
}
