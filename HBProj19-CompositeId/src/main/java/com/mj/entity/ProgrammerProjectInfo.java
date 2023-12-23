package com.mj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammerProjectInfo {
	//HAS-A property of Id class
	private ProgrammerProjId id;
	private String prgmrName;
	private String projName;
	private Double salary;
	private Double budget;
}
