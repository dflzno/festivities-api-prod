package com.github.dlozanoc.festapivity.application.domain.mappers;

import static org.junit.Assert.assertNotNull;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.integration.worldcelebrations.Celebration;

public class FromWorldCelebrationToDomainFestivityMapperTest {
	
	private FromWorldCelebrationToDomainFestivityMapper testSubject = new FromWorldCelebrationToDomainFestivityMapper();

	@Test(expected = NullPointerException.class)
	public void noNullParamAllowed() {
		// given
		Celebration celebration = null;
		
		// when
		testSubject.apply(celebration);
		
		// then
		// Ex catched on definition
	}
	
	@Test
	public void shouldReturnAFestivityObject() {
		// given
		Celebration celebration = new Celebration("A great party", ZonedDateTime.now(), ZonedDateTime.now(), "In da club");
		
		// when
		Festivity festivity = testSubject.apply(celebration);		
		
		// then
		assertNotNull(festivity);
	}

}
