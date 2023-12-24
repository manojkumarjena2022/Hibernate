package com.mj.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProgrammerProjectInfo {
	//HAS-A property of Id class
	@EmbeddedId
	private ProgrammerProjId id;
	@Column
	private String prgmrName;
	@Column
	private String projName;
	@Column
	private Double salary;
	@Column
	private Double budget;
}
