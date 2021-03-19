package com.activemq.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.activemq.demo.ActiveMqSpringBootDemoApplication;



@SpringBootTest
 class MyApplicationTest {
	
	@Test
	    void main() {
	      ActiveMqSpringBootDemoApplication.main(new String[] {});
	   }
}
