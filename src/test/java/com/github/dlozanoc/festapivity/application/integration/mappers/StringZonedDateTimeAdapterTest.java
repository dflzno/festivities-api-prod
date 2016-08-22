package com.github.dlozanoc.festapivity.application.integration.mappers;

import static org.junit.Assert.assertNotNull;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import org.junit.Test;

public class StringZonedDateTimeAdapterTest {
	
	private StringZonedDateTimeAdapter testSubject = new StringZonedDateTimeAdapter();

	@Test
	public void shouldGetAZonedDateTimeFromString() throws Exception {
		// given
		String stringDate = "2016-02-04T00:00:00-03:00";
		
		// when
		ZonedDateTime date = testSubject.unmarshal(stringDate);
		
		// then
		assertNotNull(date);
	}
	
	@Test(expected = DateTimeParseException.class)
	public void shouldTrowExceptionWhenBuildingAZonedDateTimeFromStringDueToBadFormat() throws Exception {
		// given
		String stringDate = "2016-02-04T00:00:00";
		
		// when
		testSubject.unmarshal(stringDate);
		
		// then
		// Handled on declaration
	}
	
	@Test
	public void shouldGetStringRepresentationOfZonedDateTime() throws Exception {
		// given
		ZonedDateTime date = ZonedDateTime.now();
		
		// when
		String stringDate = testSubject.marshal(date);
		
		// then
		assertNotNull(stringDate);
	}
	
	@Test(expected = NullPointerException.class)
	public void marshallingShouldThrowNPEWhenSendingNullParam() throws Exception {
		// given
		ZonedDateTime date = null;
		
		// when
		testSubject.marshal(date);
		
		// then
	}

}
