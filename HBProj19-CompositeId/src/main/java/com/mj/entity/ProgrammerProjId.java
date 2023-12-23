package com.mj.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammerProjId implements Serializable {
	public Integer prgmrId;
	public Integer projId;
}
