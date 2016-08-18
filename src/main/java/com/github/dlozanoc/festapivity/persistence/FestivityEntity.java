package com.github.dlozanoc.festapivity.persistence;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FESTIVITY")
@ToString
public class FestivityEntity {

	@Id
	@GeneratedValue
	private Long id;	
	
	private String name;
	
	@Column(name = "start_date")
	private ZonedDateTime startDate;
	
	@Column(name = "end_date")
	private ZonedDateTime endDate;
	
	private String place;
}
