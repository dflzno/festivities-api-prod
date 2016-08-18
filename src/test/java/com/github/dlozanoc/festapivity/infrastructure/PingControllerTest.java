package com.github.dlozanoc.festapivity.infrastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PingControllerTest {
	
	private PingController testSubject = new PingController();

	@Test
	public void shouldReturnStatus200WithMessage() {
		// when
		ResponseEntity<String> response = testSubject.ping();
		
		// then
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("It works!", response.getBody());
	}

}
