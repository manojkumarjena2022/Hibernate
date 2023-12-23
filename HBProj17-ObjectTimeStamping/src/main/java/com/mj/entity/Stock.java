package com.mj.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Stock {
private Integer stockId;
private String stockName;
private Float price;
private String exchange;
private Timestamp lastUpdated;
}
