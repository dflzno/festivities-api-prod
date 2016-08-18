package com.github.dlozanoc.festapivity.infrastructure;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.application.domain.mappers.FromWorldCelebrationToDomainFestivityMapper;
import com.github.dlozanoc.festapivity.application.festivities.FestivityService;
import com.github.dlozanoc.festapivity.integration.worldcelebrations.Celebration;
import com.github.dlozanoc.festapivity.integration.worldcelebrations.WorldCelebrations;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InitialFestivitiesLoader {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private FestivityService festivityService;
	
	@Autowired
	private FromWorldCelebrationToDomainFestivityMapper mapper;

	@PostConstruct
	public void load() {
		log.debug("Initializing festivities load...");
		
		WorldCelebrations result = null;
		try {
			File xmlFile = appContext.getResource("classpath:input/world-celebrations.xml").getFile();
			JAXBContext ctx = JAXBContext.newInstance(WorldCelebrations.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			result = (WorldCelebrations) unmarshaller.unmarshal(xmlFile);
			for(Celebration c : result.getCelebrations()) {
				if(c.getFrom().isAfter(c.getTo())) {
					log.debug("Skipping Celebration {}. Start date is not before end date.", c);
				} else {
					festivityService.save(mapper.apply(c));
				}
			}
		} catch (Exception e) {
			log.error("", e);
		}
		log.debug("Done loading initial festivities.");
	}
}
