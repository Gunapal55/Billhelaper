package com.onebill.billhelper.dao;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billhelper.dto.ProductsDTO;
import com.onebill.billhelper.entity.Products;

@Repository
public class ProductsDAOImplementation implements ProductsDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductsDTO addProduct(ProductsDTO product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		Products pro = new Products();
		BeanUtils.copyProperties(product, pro);
		manager.persist(pro);
		ProductsDTO dto = new ProductsDTO();
		BeanUtils.copyProperties(pro, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;
	}

	@Override
	public ProductsDTO updateProduct(ProductsDTO updateProduct) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products updatedProduct = manager.find(Products.class, updateProduct.getProductId());
		BeanUtils.copyProperties(updateProduct, updatedProduct);
		ProductsDTO dto = new ProductsDTO();
		BeanUtils.copyProperties(updatedProduct, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;
	}

	@Override
	public ProductsDTO removeProduct(ProductsDTO product) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products deletedProduct = manager.find(Products.class, product.getProductId());
		if (deletedProduct != null) {
			manager.remove(deletedProduct);
			manager.getTransaction().commit();
			manager.close();
			return product;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<ProductsDTO> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Products> query = manager.createQuery("FROM Products", Products.class);
		List<Products> products = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<ProductsDTO>>() {
		}.getType();
		List<ProductsDTO> dto = mapper.map(products, listType);
		return dto;
	}

	@Override
	public List<ProductsDTO> getProduct(ProductsDTO product) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products pro = new Products();
		BeanUtils.copyProperties(product, pro);
		TypedQuery<Products> query = manager.createQuery("FROM Products P where P.product=:value", Products.class);
		query.setParameter("value", pro);
		List<Products> output = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<ProductsDTO>>() {
		}.getType();
		List<ProductsDTO> dto = mapper.map(output, listType);
		return dto;
	}
}