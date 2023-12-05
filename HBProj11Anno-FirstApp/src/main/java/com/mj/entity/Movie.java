package com.mj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_INFO")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@DynamicInsert(value = true)
//@Proxy(lazy = false)
public class Movie {
	@Id //singular id field
	@Column(name = "MID") //mapping with column
	private Integer mid;
	@Column(name="MNAME") //mapping with column
	private String mname;
	@Column(name="HERO") //mapping with column
	private String hero;
	@Column(name="BUDGET") //mapping with column
	@Transient
	private Float budget;
	public Movie()
	{
		System.out.println("Movie.Movie()"+this.getClass());
	}
}
