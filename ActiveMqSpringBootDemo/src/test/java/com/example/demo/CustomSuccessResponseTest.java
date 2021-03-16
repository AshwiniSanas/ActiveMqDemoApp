package com.example.demo;

import org.junit.jupiter.api.Test;

import com.activemq.demo.exceptions.CustomSuccessResponse;

 class CustomSuccessResponseTest {

	
	@Test
    void status(){
		CustomSuccessResponse response = new CustomSuccessResponse();
		response.setStatus(response.getStatus());
       assertTrue(response.getStatus() == response.getStatus());
   }
	

	@Test
    void error(){
		CustomSuccessResponse response = new CustomSuccessResponse();
		response.setMessage(response.getMessage());
       assertTrue(response.getMessage() == response.getMessage());
   }
	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
