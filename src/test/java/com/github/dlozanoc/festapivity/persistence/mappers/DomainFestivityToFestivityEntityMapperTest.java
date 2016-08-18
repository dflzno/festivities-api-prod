package com.github.dlozanoc.festapivity.persistence.mappers;

import static org.junit.Assert.assertNotNull;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.persistence.FestivityEntity;

public class DomainFestivityToFestivityEntityMapperTest {

	private DomainFestivityToFestivityEntityMapper testSubject = new DomainFestivityToFestivityEntityMapper();

	@Test(expected = NullPointerException.class)
	public void noNullValueAllowed() {
		// given
		Festivity festivity = null;

		// when
		testSubject.apply(festivity);

		// then
		// Ex catched on definition
	}

	@Test
	public void shouldReturnNonNullValue() {
		// given
		Festivity festivity = new Festivity(
				1L, 
				"Cool fest", 
				ZonedDateTime.now(), 
				ZonedDateTime.now().plusHours(3),
				"Known location");

		// when
		FestivityEntity result = testSubject.apply(festivity);

		// then
		assertNotNull(result);
	}

}
