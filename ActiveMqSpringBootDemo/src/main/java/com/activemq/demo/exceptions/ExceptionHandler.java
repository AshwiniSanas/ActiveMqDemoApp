package com.activemq.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * This class is used to handle custom exceptions 
 * @author Ashwini.Sanas
 *
 */

@ControllerAdvice
public class ExceptionHandler {

   /**
    * 
    * @param ex 
    * -This is an exception object used to get the exception message
    * @param request
    * @return This return statement returns the error response
    */
	
   @org.springframework.web.bind.annotation.ExceptionHandler
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ResponseBody
   public ResponseEntity<CustomErrorResponse> handleNotFound(Exception ex,WebRequest request)
   {
    CustomErrorResponse errors = new CustomErrorResponse();
    //errors.setTimestamp(LocalDateTime.now());
    errors.setError("Invalid input "+ex.getMessage());
    errors.setStatus(HttpStatus.BAD_REQUEST.value());

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

  
   }

    /**
     * 
     * @param ex
     * -This is an exception object used to get the exception message
     * @param request
     * @return This return statement returns the error response
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(ArticleIdNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> idNotFound(ArticleIdNotFoundException ex,WebRequest request)
    {
   
     CustomErrorResponse errors = new CustomErrorResponse();
     errors.setError(ex.getMessage());
     errors.setStatus(HttpStatus.NOT_FOUND.value());

     return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
    
    
    /**
     * 
     * @param ex
     * -This is an exception object used to get the exception message
     * @param request
     * @return This return statement returns the error response
     */
    
    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<CustomErrorResponse> invalidInput(InvalidInputException ex,WebRequest request)
    {
     
       CustomErrorResponse errors = new CustomErrorResponse();
       errors.setError(ex.getMessage());
       errors.setStatus(HttpStatus.BAD_REQUEST.value());

       return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    
      }
}