package com.accn.ppes.magellan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUtility implements Productservice {
	
	@Autowired
	ProductRespository productRespository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	
	@Override
	public Product getProductById(Long id) {
		Product productcount = productRespository.findByProductID(id);

		if (productcount == null)
			throw new com.accn.ppes.magellan.exception.ProductNotFoundException(id);
		else {
			return productcount;
		}
	}
	
	@Override
	public Product saveProduct(Product product) {
		try {
			product.setCategoryCodeId(categoryRepository.findByCode(product.getCategoryCode()));
			product.setBrandId(brandRepository.findByName(product.getBrandName()));
			Product created = productRespository.save(product);
			return created;
		} catch (Exception e) {
			throw new com.accn.ppes.magellan.exception.ProductNotFoundException(product.productID);
		}
		
	}
	
	@Override
	public String deleteProductbyID(Long id) {
		   try {
			   productRespository.delete(id);	
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.ProductNotFoundException(id);
				}
				return "product deleted!";
	}
	
	@Override
	public Product updateProductbyID(Product product) {
		// TODO Auto-generated method stub
		try {
			   productRespository.save(product);	
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.ProductNotFoundException(product.getProductID());
				}
				return product;
	}

	@Override
	public Collection<Product> getAllProduct() {
		// TODO Auto-generated method stub
		Collection<Product> products = productRespository.findAll();
        return products;
	}
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository.findAll();
        return categories;
	}
	
	@Override
	public List<Brand> getAllBrand() {
		// TODO Auto-generated method stub
		List<Brand> brands = brandRepository.findAll();
        return brands;
	}
	

	@Override
	public Product getByName(String productName) {
		// TODO Auto-generated method stub
		return productRespository.findByName(productName);
	}

	@Override
	public Collection<Product> getByDescription(String description) {
		// TODO Auto-generated method stub
		Collection<Product> products = productRespository.findByDescription(description);
		return products;
	}

	@Override
	public Collection<Product> getBySize(String size) {
		// TODO Auto-generated method stub
		return productRespository.findBySize(size);
	}

	@Override
	public Collection<Product> getByFlavour(String flavour) {
		return productRespository.findByFlavour(flavour);
	}

	@Override
	public Collection<Product> getByCategoryId(Category categoryId) {
		
		return productRespository.findByCategoryCodeId(categoryId);
	}
	
	@Override
	public Collection<Category> getByParent(Category parentCategory) {

		return categoryRepository.findByParent(parentCategory);
	}
	@Override
	public Category getByCategoryCode(String productCategoryCode) {
		
		return categoryRepository.findByCode(productCategoryCode);
	}
	
	@Override
	public Category saveProductCatagory(Category productCatagory) {
		return categoryRepository.save(productCatagory);
	}
	
	@Override
	public Brand saveProductBrand(Brand productBrand) {
		return brandRepository.save(productBrand);
	}

	@Override
	public Collection<Product> getByActiveflag(String activeflag) {
		return productRespository.findByActiveflag(activeflag);
	}

	@Override
	public Collection<Product> getByPrice(Double price) {
		return productRespository.findByPrice(price);
	}

	@Override
	public Collection<Product> getByDiscount(Double discount) {
		return productRespository.findByDiscount(discount);
	}

	@Override
	public Collection<Product> getByColor(String color) {
		// TODO Auto-generated method stub
		return productRespository.findByColor(color);
	}

	@Override
	public Product updateProductbyName(Product product) {
		// TODO Auto-generated method stub
		try {
			   productRespository.save(product);	
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.ProductNotFoundException(product.getName());
				}
				return product;
		
	}

	@Override
	public String deleteProductbyName(String name) {
		try {
			   Product product = productRespository.findByName(name);
			  productRespository.delete(product);
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.ProductNotFoundException(name);
				}
				return "product deleted!";
	}

	@Override
	public Brand getByBrandName(String brandName) {
		return brandRepository.findByName(brandName);
	}

	@Override
	public Collection<Product> getByBrandId(Brand brandId) {
		return productRespository.findByBrandId(brandId);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Collection<Product> getProductsByParentCategory(String parentCategoryCode) {
		Category parentCategory = getByCategoryCode(parentCategoryCode);
		   Collection<Category> subCategories = getByParent(parentCategory);
		   Collection<Product> products = new ArrayList<Product>();
	 		System.out.println("Sub Categories: "+subCategories);
	 		for(Category category : subCategories)
	 		{
	 			System.out.println("Sub Categories product: "+getByCategoryId(category));
	 			products.addAll(getByCategoryId(category));
	 		}
	 		System.out.println("Sub Categories all product: "+products);
		return products;
	}

	

	

	

}
