package com.mj.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProgrammerProjId implements Serializable {
	public Integer prgmrId;
	public Integer projId;
}
