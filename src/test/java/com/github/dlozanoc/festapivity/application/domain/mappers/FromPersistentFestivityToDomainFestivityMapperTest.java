package com.github.dlozanoc.festapivity.application.domain.mappers;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.persistence.FestivityEntity;

public class FromPersistentFestivityToDomainFestivityMapperTest {

	private FromPersistentFestivityToDomainFestivityMapper testSubject = new FromPersistentFestivityToDomainFestivityMapper();
	
	@Test(expected = NullPointerException.class)
	public void noNullParamAllowed() {
		// given
		List<FestivityEntity> persFestivities = null;
		
		// when
		testSubject.apply(persFestivities);
		
		// then
		// catched on definition
	}
	
	@Test
	public void shouldReturnADomainEntity() {
		// given
		List<FestivityEntity> persFestivities = Arrays.asList(
				new FestivityEntity[] {
				    new FestivityEntity(1L, "Fest", ZonedDateTime.now(), ZonedDateTime.now(), "Some place"),
				    new FestivityEntity(2L, "Fest 2", ZonedDateTime.now(), ZonedDateTime.now(), "Another place")
				});
		
		// when
		List<Festivity> domainFestivities = testSubject.apply(persFestivities);
		
		// then
		assertEquals(2, domainFestivities.size());
	}

}
