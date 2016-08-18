package com.github.dlozanoc.festapivity.application.integration.mappers;

import java.time.ZonedDateTime;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.application.integration.FestivityResource;

@Component
public class FestivityMapper implements Function<FestivityResource, Festivity> {

	@Override
	public Festivity apply(FestivityResource t) {
		return new Festivity(
				null, 
				t.getName(), 
				ZonedDateTime.parse(t.getStartDate()), 
				ZonedDateTime.parse(t.getEndDate()),  
				t.getPlace());				
	}

	
}
