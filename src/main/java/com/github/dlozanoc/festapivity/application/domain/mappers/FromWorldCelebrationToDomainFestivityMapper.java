package com.github.dlozanoc.festapivity.application.domain.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.integration.worldcelebrations.Celebration;

import lombok.NonNull;

@Component
public class FromWorldCelebrationToDomainFestivityMapper implements Function<Celebration, Festivity> {

	@Override
	public Festivity apply(@NonNull Celebration t) {
		return new Festivity(null, t.getWhat(), t.getFrom(), t.getTo(), t.getWhere());
	}

}
