package com.accn.ppes.magellan;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Brand")
@Proxy(lazy = false)
public class Brand {
	
	@Id
	@GeneratedValue
	@Column(name = "brandid")
	Long brandId;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="brandId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference("Brand")
	private Set<Product> product = new HashSet<Product>();
	
	
	public Brand(Long brandId, String name, String description, Set<Product> product) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.description = description;
		this.product = product;
	}
	public Brand() {
		
	}
	
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Brand [id=" + brandId + ", name=" + name + ", description=" + description + ", product=" + product + "]";
	}
	
}
