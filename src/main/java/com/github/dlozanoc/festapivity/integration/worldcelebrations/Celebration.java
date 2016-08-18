package com.github.dlozanoc.festapivity.integration.worldcelebrations;

import java.time.ZonedDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.dlozanoc.festapivity.integration.mappers.StringZonedDateTimeAdapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@XmlRootElement(name = "celebration")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Celebration {

	@Getter @XmlElement private String what;
	@Getter @XmlElement @XmlJavaTypeAdapter(StringZonedDateTimeAdapter.class) private ZonedDateTime from;
	@Getter @XmlElement @XmlJavaTypeAdapter(StringZonedDateTimeAdapter.class) private ZonedDateTime to;
	@Getter @XmlElement private String where;
	
}
