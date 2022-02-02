package com.arrgew.webshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Integer price;
	private String imgUrl;

	public Item(String name, String description, Integer price, String imgurl) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgurl;
	}
}
