package com.starlight.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 254653461L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private String image;

	@Column
	private String icon;
	
	@Column
	private Long code;
	
	@Column
	private Long stock;
	
	@Column
	private Double initialQuantity;
	
	@Column
	private int countUncount;

//	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
//	private Set<Lista> listas = new HashSet<Lista>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Double getInitialQuantity() {
		return initialQuantity;
	}

	public void setInitialQuantity(Double initialQuantity) {
		this.initialQuantity = initialQuantity;
	}

	public int getCountUncount() {
		return countUncount;
	}

	public void setCountUncount(int countUncount) {
		this.countUncount = countUncount;
	}

//	public Set<Lista> getListas() {
//		return listas;
//	}
//
//	public void setListas(Set<Lista> listas) {
//		this.listas = listas;
//	}
}
