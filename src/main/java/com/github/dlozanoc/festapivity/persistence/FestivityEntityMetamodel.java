package com.github.dlozanoc.festapivity.persistence;

import java.time.ZonedDateTime;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(FestivityEntity.class)
public class FestivityEntityMetamodel {

	public static volatile SingularAttribute<FestivityEntity, Long> id;
	public static volatile SingularAttribute<FestivityEntity, String> name;
	public static volatile SingularAttribute<FestivityEntity, ZonedDateTime> startDate;
	public static volatile SingularAttribute<FestivityEntity, ZonedDateTime> endDate;
	public static volatile SingularAttribute<FestivityEntity, String> place;
}
