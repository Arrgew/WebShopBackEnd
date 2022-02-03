package com.arrgew.webshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String description;
	@Column(nullable = false)
	private BigDecimal price;
	private String imgUrl;

	@ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JsonManagedReference
	private Set<Tag> tags;

	public Item(String name, String description, BigDecimal price, String imgurl, Set<Tag> tags) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgurl;
		setTags(tags);
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
		if(!tags.isEmpty()){
		for(Tag tag : tags){
			tag.getItems().add(this);}}
	}
}
