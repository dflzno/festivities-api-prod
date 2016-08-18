package com.github.dlozanoc.festapivity.application.integration.mappers;

import static org.junit.Assert.*;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.application.integration.FestivityResource;

public class FestivityResourceMapperTest {

	private FestivityResourceMapper testSubject = new FestivityResourceMapper();

	@Test(expected = NullPointerException.class)
	public void noNullParamAllowed() {
		// given
		Festivity f = null;

		// when
		testSubject.apply(f);

		// then
	}

	@Test
	public void shouldReturnAFestivityResource() {
		// given
		Festivity festivity = new Festivity(1L, "Cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Known location");

		// when
		FestivityResource resource = testSubject.apply(festivity);

		// then
		assertNotNull(resource);
	}
	
	@Test
	public void shouldReturnFestivityDatesWithoutNameOfTimezone() {
		// given
		Festivity festivity = new Festivity(1L, "Cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Known location");

		// when
		FestivityResource resource = testSubject.apply(festivity);

		// then
		assertEquals(1, resource.getEndDate().split("\\[").length);
		assertEquals(1, resource.getStartDate().split("\\[").length);
	}
}
