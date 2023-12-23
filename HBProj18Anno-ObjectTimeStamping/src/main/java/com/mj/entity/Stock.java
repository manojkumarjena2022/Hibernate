package com.mj.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Stock {
	@Id
	@GeneratedValue
	private Integer stockId;
	@NonNull
	@Column(length = 20)
	private String stockName;
	@NonNull
	@Column
	private Float price;
	@NonNull
	@Column(length = 10)
	private String exchange;
	@CreationTimestamp
	private Timestamp launchTime;
	@Version
	private Integer updationCount;
	@UpdateTimestamp
	private Timestamp lastUpdated;
}
