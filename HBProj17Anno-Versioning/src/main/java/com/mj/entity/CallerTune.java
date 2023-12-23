package com.mj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name = "CALLERTUNE")
public class CallerTune {
	@Id
	@GeneratedValue
	private Integer tuneId;
	@Column(length = 20)
	private String tuneName;
	@Column(name="MNAME",length = 15)
	private String movieName;
	@Version
	private Integer updationCount;
}
