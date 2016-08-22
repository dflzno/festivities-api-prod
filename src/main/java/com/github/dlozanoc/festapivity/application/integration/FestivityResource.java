package com.github.dlozanoc.festapivity.application.integration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "festivity")
public class FestivityResource extends ResourceSupport {
	
	@XmlElement private Long festId;
	@XmlElement private String name;
	@XmlElement(name = "start") private String startDate;
	@XmlElement(name = "end") private String endDate;
	@XmlElement private String place;
}