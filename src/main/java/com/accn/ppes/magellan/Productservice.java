package com.accn.ppes.magellan;

import java.util.Collection;
import java.util.List;

//Comments
public interface Productservice {
	public Product getProductById(Long id);

	public Product saveProduct(Product commodity);
	
	//public Category saveProductCatagory(Category productCatagory);

	public Collection<Product> getAllProduct();
	
	public List<Category> getAllCategory();
	
	public List<Brand> getAllBrand();
	
	public Product updateProductbyID(Product commodity);

	public String deleteProductbyID(Long id);

	public Product updateProductbyName(Product commodity);

	public String deleteProductbyName(String name);

	public Product getByName(String productName);

	public Collection<Product> getByDescription(String description);

	public Collection<Product> getBySize(String size);

	public Collection<Product> getByFlavour(String flavour);

	public Collection<Product> getByCategoryId(Category categoryId);
	
	public Category saveProductCatagory(Category productCatagory);
	
	public Brand saveProductBrand(Brand productBrand);

	public Category getByCategoryCode(String productCategoryCode);

	public Collection<Category> getByParent(Category parentCategory);
	
	public Collection<Product> getProductsByParentCategory(String parentCategory);

	public Collection<Product> getByActiveflag(String activeflag);

	public Collection<Product> getByPrice(Double price);

	public Collection<Product> getByDiscount(Double discount);

	public Collection<Product> getByColor(String color);

	public Collection<Product> getByBrandId(Brand brandId);

	public Brand getByBrandName(String brandName);
	
	public Category saveCategory(Category category);
	
	public Brand saveBrand(Brand brand);

}
