package com.github.dlozanoc.festapivity.application.domain;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Festivity {

	private Long id;
	private String name;
	private ZonedDateTime startDate;
	private ZonedDateTime endDate;
	private String place;
}
