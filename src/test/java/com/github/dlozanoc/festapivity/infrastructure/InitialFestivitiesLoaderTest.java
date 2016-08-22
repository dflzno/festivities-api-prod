package com.github.dlozanoc.festapivity.infrastructure;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.dlozanoc.festapivity.application.festivities.FestivityRepository;
import com.github.dlozanoc.festapivity.configuration.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
@WebAppConfiguration
public class InitialFestivitiesLoaderTest {

	@Autowired
	private InitialFestivitiesLoader testSubject;

	@Autowired
	private FestivityRepository festivityRepository;
	
	@Before
	public void cleanUp() {
		festivityRepository.deleteAll();
	}

	@Test
	public void shouldLoad1000InitialFestivities() {
		// when
		testSubject.load();

		// then
		assertEquals(1000, festivityRepository.count());

	}

}
