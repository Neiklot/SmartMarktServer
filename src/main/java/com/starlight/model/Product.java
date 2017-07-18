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
import javax.persistence.Transient;

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

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<Lista> listas = new HashSet<Lista>();

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

//	public Set<Lista> getListas() {
//		return listas;
//	}
//
//	public void setListas(Set<Lista> listas) {
//		this.listas = listas;
//	}
}
