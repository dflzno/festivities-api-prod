package com.github.dlozanoc.festapivity.application.integration;

import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FestivityResource {
	
	@XmlElement private Long id;
	@XmlElement private String name;
	@XmlElement private String startDate;
	@XmlElement private String endDate;
	@XmlElement private String place;
}
