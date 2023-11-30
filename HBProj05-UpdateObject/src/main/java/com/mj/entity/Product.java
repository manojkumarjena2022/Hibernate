package com.mj.entity;

import lombok.Data;

@Data
public class Product { //make final for eager loading
	private Integer pid;
	private String pname;
	private Float price;
	private Float qty;
	public Product()
	{
		System.out.println("Product.Product() -- "+this.getClass());
	}
}
