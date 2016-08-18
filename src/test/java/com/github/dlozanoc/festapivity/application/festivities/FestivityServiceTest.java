package com.github.dlozanoc.festapivity.application.festivities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.configuration.ApplicationConfiguration;
import com.github.dlozanoc.festapivity.persistence.FestivityEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
@WebAppConfiguration
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class FestivityServiceTest {

	@Mock
	private FestivityRepository festivityRepository;

	@InjectMocks
	@Autowired
	private FestivityService testSubject;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAllFestivities() {
		// given
		List<FestivityEntity> dbFestivities = Arrays.asList(
				new FestivityEntity(1L, "Cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Wonderland"),
				new FestivityEntity(2L, "Another cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Wonderland"));
		when(festivityRepository.findAll()).thenReturn(dbFestivities);

		// when
		Optional<List<Festivity>> festivities = testSubject.getAll();

		// then
		assertEquals(2, festivities.get().size());
	}

	@Test
	public void shouldNotReturnFestivitiesDueToError() {
		// given
		when(festivityRepository.findAll()).thenThrow(new HibernateException(""));

		// when
		Optional<List<Festivity>> festivities = testSubject.getAll();

		// then
		assertFalse(festivities.isPresent());
	}

	@Test
	public void shouldSaveFestivity() {
		// given
		Festivity festivity = new Festivity(1L, "Cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Known location");

		// when
		boolean result = testSubject.save(festivity);

		// then
		assertTrue(result);
	}
	
	@Test
	public void shouldNotSaveFestivitiesDueToError() {
		// given
		Festivity festivity = new Festivity(1L, "Cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Known location");
		when(festivityRepository.save(any(FestivityEntity.class))).thenThrow(new HibernateException(""));

		// when
		boolean result = testSubject.save(festivity);

		// then
		assertFalse(result);
	}
	
	@Test
	public void shouldFindFestivityById() {
		// given
		when(festivityRepository.findOne(1L)).thenReturn(new FestivityEntity(1L, "Cool fest", ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), "Wonderland"));
		
		// when
		Optional<Festivity> festivity = testSubject.getById(1L);
		
		// then
		assertTrue(festivity.isPresent());
	}
	
	@Test
	public void shouldNotFindFestivityByIdDueToError() {
		// given
		when(festivityRepository.findOne(1L)).thenThrow(new HibernateException(""));
		
		// when
		Optional<Festivity> festivity = testSubject.getById(1L);
		
		// then
		assertFalse(festivity.isPresent());
	}
}
