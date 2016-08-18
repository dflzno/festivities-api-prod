package com.github.dlozanoc.festapivity.application.domain.mappers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.dlozanoc.festapivity.persistence.FestivityEntity;

import lombok.NonNull;

@Component
public class FromPersistentFestivityToDomainFestivityMapper 
	implements Function<List<com.github.dlozanoc.festapivity.persistence.FestivityEntity>, 
						List<com.github.dlozanoc.festapivity.application.domain.Festivity> > {

	@Override
	public List<com.github.dlozanoc.festapivity.application.domain.Festivity> apply(@NonNull List<FestivityEntity> t) {
		return t.stream().map(f -> apply(f)).collect(Collectors.toList());
	}
	
	public com.github.dlozanoc.festapivity.application.domain.Festivity apply(FestivityEntity t) {
		com.github.dlozanoc.festapivity.application.domain.Festivity fest = 
				new com.github.dlozanoc.festapivity.application.domain.Festivity(
						t.getId(), t.getName(), t.getStartDate(), t.getEndDate(), t.getPlace());
		return fest;
	}


}
