package com.accn.ppes.magellan;


import java.util.Collection;


import org.springframework.data.repository.Repository;





public interface ProductRespository extends Repository<Product, Long> {

	public Product findByProductID(Long id);
	public Product save(Product saved);
	
	public String delete(Long id);
	
	public String delete(Product product);
	
	public Collection<Product> findAll();
	public Product findByName(String productName); 
	public Collection<Product> findByDescription(String description);
	public Collection<Product> findBySize(String size);
	public Collection<Product> findByFlavour(String flavour);
	public Collection<Product> findByCategoryCodeId(Category categoryId);
	public Collection<Product> findByActiveflag(String activeflag);
	public Collection<Product> findByPrice(Double price);
	public Collection<Product> findByDiscount(Double discount);
	public Collection<Product> findByColor(String color);
	public Collection<Product> findByBrandId(Brand brandId);
}