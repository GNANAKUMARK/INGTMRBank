package com.ing.tmrbank.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ing.tmrbank.controller.BeneficiaryController;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(CustomExceptionHandler.class);
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails( ex.getMessage(),
	        request.getDescription(false));
	    LOGGER.error(ex);
	    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	    if(ex instanceof DataNotFoundException ) {
	    	status = HttpStatus.NOT_FOUND;
	    } else if(ex instanceof BADRequestException) {
	    	status = HttpStatus.BAD_REQUEST;
	    }
	    return new ResponseEntity<>(errorDetails, status );
	  }

}
