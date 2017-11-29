package com.accn.ppes.magellan;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
@Proxy(lazy = false)
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2049669398774154151L;

	/**
	 * 
	 */

	/**
	 * 
	 */

	@Id
	@GeneratedValue
	Long productID;

	@Column(unique = true)
	private String name;

	@Column
	private String description;

	@Column
	private String size;

	@Column
	private String flavour;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categorycodeid", nullable = false)
	@JsonBackReference("Category")
	private Category categoryCodeId;

	@Column(name = "categorycode")
	private String categoryCode;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column
	private String activeflag;

	@Column
	private double price;

	@Column
	private double discount;

	@Column
	private String color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brandid", nullable = false)
	@JsonBackReference("Brand")
	private Brand brandId ;
	
	@Column(name = "brandname")
	private String brandName;

	public Product()
	{}
	public Product(Long productID, String name, String description, String size, String flavour, Category categoryCodeId,
			String activeflag, double price, double discount, String color, Brand brandId) {
		super();
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.size = size;
		this.flavour = flavour;
		this.categoryCodeId = categoryCodeId;
		this.activeflag = activeflag;
		this.price = price;
		this.discount = discount;
		this.color = color;
		this.brandId = brandId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	

	public String getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(String activeflag) {
		this.activeflag = activeflag;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Category getCategoryCodeId() {
		return categoryCodeId;
	}

	public void setCategoryCodeId(Category categoryCode) {
		this.categoryCodeId = categoryCode;
	}

	public Brand getBrandId() {
		return brandId;
	}

	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}

	/*@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", description=" + description + ", size=" + size
				+ ", flavour=" + flavour + ", categoryCodeId=" + categoryCodeId + ", activeflag=" + activeflag + ", price="
				+ price + ", discount=" + discount + ", color=" + color + ", brandId=" + brandId + "]";
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
