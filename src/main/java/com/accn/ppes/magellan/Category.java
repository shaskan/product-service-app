package com.accn.ppes.magellan;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
@Proxy(lazy = false)
public class Category {
	
	@Id
	@Column(name = "categorycodeid")
	@GeneratedValue
	Long categoryCodeId;
	
	@Column
	private String code;
	
	@Column
	private String description;
	
	/*@Column
	private Long parent_id;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private Category parent;
	
	@OneToMany(mappedBy="parent",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Category> subCategories = new HashSet<Category>();
	
	@OneToMany(mappedBy="categoryCodeId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference("Category")
	private Set<Product> product = new HashSet<Product>();
	
	

	public Category() {
	}

	public Category(Long id, String code, String description, Category parent, Set<Category> subCategories,
			Set<Product> product) {
		super();
		this.categoryCodeId = id;
		this.code = code;
		this.description = description;
		this.parent = parent;
		this.subCategories = subCategories;
		this.product = product;
	}

	public Long getCategoryCodeId() {
		return categoryCodeId;
	}
	
	public void setCategoryCodeId(Long id) {
		this.categoryCodeId = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
	public Set<Category> getSubordinates() {
		return subCategories;
	}

	public void setSubordinates(Set<Category> subordinates) {
		this.subCategories = subordinates;
	}

	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	/*@Override
	public String toString() {
		return "Category [id=" + categoryCodeId + ", code=" + code + ", description=" + description + "]";
	}*/
	
	

}
