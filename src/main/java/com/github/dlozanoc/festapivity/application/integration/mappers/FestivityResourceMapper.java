package com.github.dlozanoc.festapivity.application.integration.mappers;

import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.application.integration.FestivityResource;

import lombok.NonNull;

@Component
public class FestivityResourceMapper implements Function<Festivity, FestivityResource> {

	@Override
	public FestivityResource apply(@NonNull Festivity t) {
		return new FestivityResource(
				t.getId(), 
				t.getName(), 
				t.getStartDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
				t.getEndDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
				t.getPlace());
	}

}
