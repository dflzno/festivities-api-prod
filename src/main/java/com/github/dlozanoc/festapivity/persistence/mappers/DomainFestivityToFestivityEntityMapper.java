package com.github.dlozanoc.festapivity.persistence.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.persistence.FestivityEntity;

import lombok.NonNull;

@Component
public class DomainFestivityToFestivityEntityMapper implements Function<Festivity, FestivityEntity> {

	@Override
	public FestivityEntity apply(@NonNull Festivity f) {
		FestivityEntity festivity = new FestivityEntity();
		festivity.setName(f.getName());
		festivity.setStartDate(f.getStartDate());
		festivity.setEndDate(f.getEndDate());
		festivity.setPlace(f.getPlace());
		return festivity;
	}

}
