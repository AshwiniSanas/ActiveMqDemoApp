package com.activemq.demo.exceptions;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * This class declares fields for successful request response body
 * @author Ashwini.Sanas
 *
 */

@Getter @Setter
public class CustomSuccessResponse {
	
  
    private int status;
    private String message;

    
    /**
     * 
     * @return responseSuccess
     */
    public CustomSuccessResponse returnResponse()
    {
    String response="Success";
    
         CustomSuccessResponse responseSuccess=new CustomSuccessResponse();
         responseSuccess.setStatus(HttpStatus.OK.value());
         responseSuccess.setMessage(response);
     
         return responseSuccess;
    }
}

