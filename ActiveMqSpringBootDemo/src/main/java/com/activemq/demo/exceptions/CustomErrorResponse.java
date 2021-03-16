package com.activemq.demo.exceptions;



import lombok.Getter;
import lombok.Setter;

/**
 * This class declares fields for error response body
 * @author Ashwini.Sanas
 *
 */

@Getter @Setter
public class CustomErrorResponse {

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    //private LocalDateTime timestamp;
    private int status;
    private String error;

   
}
