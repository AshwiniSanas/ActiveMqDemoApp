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
	
  
    private int status=HttpStatus.OK.value();
    private String message="Success";
    
}

