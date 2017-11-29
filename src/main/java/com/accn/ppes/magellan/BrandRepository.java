package com.accn.ppes.magellan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	public Brand findByName(String brandName);
	public Brand save(Brand productBrand);
	public List<Brand> findAll();

}
