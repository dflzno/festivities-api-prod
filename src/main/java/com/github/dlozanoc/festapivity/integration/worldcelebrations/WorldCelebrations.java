package com.github.dlozanoc.festapivity.integration.worldcelebrations;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "world-celebrations")
@NoArgsConstructor
@AllArgsConstructor
public class WorldCelebrations {

	@Getter @XmlElement(name = "celebration") private List<Celebration> celebrations;
}
