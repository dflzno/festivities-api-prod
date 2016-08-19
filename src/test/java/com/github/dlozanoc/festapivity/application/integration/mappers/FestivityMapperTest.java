package com.github.dlozanoc.festapivity.application.integration.mappers;

import static org.junit.Assert.assertNotNull;

import java.time.format.DateTimeParseException;

import org.junit.Test;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.application.integration.FestivityResource;

public class FestivityMapperTest {
	
	private FestivityMapper testSubject = new FestivityMapper();

	@Test(expected = NullPointerException.class)
	public void noNullParamAllowed() {
		// given
		FestivityResource resource = null;
		
		// when
		testSubject.apply(resource);
		
		// then
		// handled on definition
	}
	
	@Test
	public void shouldReturnNewFestivity() {
		// given
		FestivityResource resource = new FestivityResource(1L, "National Fest", "2016-02-04T00:00:00Z", "2016-02-04T00:00:00Z", "Some country");
		
		// when
		Festivity result = testSubject.apply(resource);
		
		// then
		assertNotNull(result);
	}
	
	@Test(expected = DateTimeParseException.class)
	public void shouldFailDueToMalformedDate() {
		// given
		FestivityResource resource = new FestivityResource(1L, "National Fest", "2016-02-04", "2016-02-04T00:00:00Z", "Some country");
		
		// when
		testSubject.apply(resource);
		
		// then
		// handled on definition
	}

}
