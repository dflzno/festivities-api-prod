package com.github.dlozanoc.festapivity.infrastructure;

import java.io.File;
import java.time.ZonedDateTime;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.application.festivities.FestivityService;
import com.github.dlozanoc.festapivity.application.integration.FestivityListResource;
import com.github.dlozanoc.festapivity.application.integration.FestivityResource;
import com.github.dlozanoc.festapivity.application.integration.mappers.FestivityMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InitialFestivitiesLoader {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private FestivityService festivityService;
	
	@Autowired
	private FestivityMapper mapper;

	@PostConstruct
	public void load() {
		log.debug("Initializing festivities load...");
		
		FestivityListResource result = null;
		try {
			File xmlFile = appContext.getResource("classpath:input/festivities.xml").getFile();
			JAXBContext ctx = JAXBContext.newInstance(FestivityListResource.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			result = (FestivityListResource) unmarshaller.unmarshal(xmlFile);
			for(FestivityResource c : result.getFestivities()) {
				if(ZonedDateTime.parse(c.getStartDate()).isAfter(ZonedDateTime.parse(c.getEndDate()))) {
					log.debug("Skipping Festivity {}. Start date is not before end date.", c);
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
