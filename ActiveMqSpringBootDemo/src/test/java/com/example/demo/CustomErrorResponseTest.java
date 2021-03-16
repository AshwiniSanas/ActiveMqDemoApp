package com.example.demo;

import org.junit.jupiter.api.Test;

import com.activemq.demo.CustomErrorResponse;

 class CustomErrorResponseTest {

	
	
	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Test
     void status(){
		CustomErrorResponse response = new CustomErrorResponse();
		response.setStatus(response.getStatus());
        assertTrue(response.getStatus() == response.getStatus());
    }
	
	@Test
     void error(){
		CustomErrorResponse response = new CustomErrorResponse();
		response.setError(response.getError());
        assertTrue(response.getError() == response.getError());
    }
	
}
