package com.github.dlozanoc.festapivity.application.integration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "festivities")
public class FestivityListResource  extends ResourceSupport {
	
	@XmlElement(name="festivity") private List<FestivityResource> festivities;
}
