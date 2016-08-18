package com.github.dlozanoc.festapivity.application.integration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.Resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "festivities")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FestivityListResource {
	
	@XmlElement(name="festivity") private List<Resource<FestivityResource>> festivities;
}
