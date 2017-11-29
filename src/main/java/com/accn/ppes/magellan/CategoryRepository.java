package com.accn.ppes.magellan;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,	Long> {
	
	public Category findByCode(String categoryName);
	public Collection<Category> findByParent(Category categoryName);
	public Category save(Category productCatagory);
	public List<Category> findAll();

}
