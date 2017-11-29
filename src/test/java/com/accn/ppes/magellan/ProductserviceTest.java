package com.accn.ppes.magellan;

import java.util.Collection;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.accn.ppes.magellan.Product;
import com.accn.ppes.magellan.Productservice;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
public class ProductserviceTest extends AbstractTest {

	@Autowired
	private Productservice productService;

	@Test
	public void test1Create() {

		

		Category parentCategory = new Category();
		//Long longid= new Long(1);
		//parentCategory.setCategoryCodeId(longid);
		parentCategory.setCode("ELE");
		parentCategory.setDescription("Electronics");
		productService.saveCategory(parentCategory);

		Category secondParentCategory = new Category();
		//Long secondLongid= new Long(2);
		//secondParentCategory.setCategoryCodeId(secondLongid);
		secondParentCategory.setCode("APP");
		secondParentCategory.setDescription("Appliances");
		productService.saveCategory(secondParentCategory);

		Category subCategory = new Category();
		//Long sublongid= new Long(3);
		//subCategory.setCategoryCodeId(sublongid);
		subCategory.setCode("MOBL");
		subCategory.setDescription("Mobiles");
		subCategory.setParent(parentCategory);
		productService.saveCategory(subCategory);

		Category secondSubCategory = new Category();
		//Long secondSublongid= new Long(4);
		//secondSubCategory.setCategoryCodeId(secondSublongid);
		secondSubCategory.setCode("WSM");
		secondSubCategory.setDescription("Washing Machine");
		secondSubCategory.setParent(secondParentCategory);
		productService.saveCategory(secondSubCategory);
		
		Brand brand = new Brand();
		//Long brandlongid= new Long(123);
		//brand.setBrandId( brandlongid);
		brand.setName("APPLE");
		brand.setDescription("APPLE");
        brand = productService.saveBrand(brand);
		
		Product entity = new Product();
		entity.setName("TV");
		entity.setPrice(40000.0);
		entity.setCategoryCode(subCategory.getCode());
		entity.setSize("4");
		entity.setDescription("writing pen");
		entity.setColor("BLUE");
		entity.setFlavour("NA");
		entity.setDiscount(0);
		entity.setBrandName(brand.getName());
		
		Brand secondbrand = new Brand();
	//	Long secondBrandLongId= new Long(212);
//		 secondbrand.setBrandId(secondBrandLongId);
		secondbrand.setName("MOTOrolo");
		secondbrand.setDescription("MOTOrolo");
        secondbrand = productService.saveBrand(secondbrand);
		
		Product secondentity = new Product();
		secondentity.setName("MONTEX");
		secondentity.setPrice(20000.0);
		secondentity.setCategoryCode(secondSubCategory.getCode());
		secondentity.setSize("4");
		secondentity.setDescription("writing pen");
		secondentity.setColor("BLACK");
		secondentity.setFlavour("NA");
		secondentity.setDiscount(10.0);
		secondentity.setBrandName(secondbrand.getName());

		
		
		
		Product createdEntity = productService.saveProduct(entity);
		productService.saveProduct(secondentity);
		Assert.assertNotNull("failure - expected not null", createdEntity);
		Assert.assertNotNull("failure - expected id attribute not null" + createdEntity.getProductID(),
				createdEntity.getProductID());
		Assert.assertEquals("failure - expected Product Name attribute match", "TV", createdEntity.getName());
		Assert.assertEquals("failure - expected Product Price attribute match", 40000.0, createdEntity.getPrice(), 0);
		

		Collection<Product> list = productService.getAllProduct();

		Assert.assertEquals("failure - expected size", 2, list.size());
	}

	@Test
	public void test2FindAll() {

		Collection<Product> list = productService.getAllProduct();

		Assert.assertNotNull("failure - expected not null", list);
		Assert.assertEquals("failure - expected list size", 2, list.size());

	}

	@Test
	public void test3FindOne() {

		Long id = new Long(1);

		Product entity = productService.getProductById(id);

		Assert.assertNotNull("failure - expected not null", entity);
		Assert.assertEquals("failure - expected id attribute match", id, entity.getProductID());

	}
	
	@Test
	public void testFindByCategory()
	{
		
		Category category = productService.getByCategoryCode("WSM");
  		Collection<Product> products = productService.getByCategoryId(category);
  		
  		Assert.assertNotNull("failure - expected not null", products);
		Assert.assertEquals("failure - expected list size", 1, products.size());

		
	}
	
	@Test
	public void testFindByParentCategory()
	{
		
		
  		Collection<Product> products = productService.getProductsByParentCategory("APP");
  		
  		Assert.assertNotNull("failure - expected not null", products);
		Assert.assertEquals("failure - expected list size", 1, products.size());

		
	}
	@Test
	public void test4Update() {

		Long id = new Long(1);

		Product entity = productService.getProductById(id);

		Assert.assertNotNull("failure - expected not null", entity);

		String updatedText = "PARKER";
		entity.setName(updatedText);
		Product updatedEntity = productService.updateProductbyID(entity);

		Assert.assertNotNull("failure - expected not null", updatedEntity);
		Assert.assertEquals("failure - expected id attribute match", id, updatedEntity.getProductID());
		Assert.assertEquals("failure - expected text attribute match", updatedText, updatedEntity.getName());

	}

	@Test
	public void test5Delete() {

		Long id = new Long(1);

		Collection<Product> entities = productService.getAllProduct();

		Product entity = productService.getProductById(id);

		System.out.println(entities.toString());

		Assert.assertNotNull("failure - expected not null", entity);

		productService.deleteProductbyID(id);

		Collection<Product> list = productService.getAllProduct();

		Assert.assertEquals("failure - expected size", 1, list.size());

	}
	
}
