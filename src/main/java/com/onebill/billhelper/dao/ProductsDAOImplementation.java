package com.onebill.billhelper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billhelper.entity.Products;

@Repository
public class ProductsDAOImplementation implements ProductsDAO{

	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public Products addProduct(Products product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		manager.persist(product);
		manager.getTransaction().commit();
		manager.close();
		return product;
	}

	@Override
	public Products updateProduct(Products updateProduct) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products updatedProduct= manager.find(Products.class, updateProduct.getProductId());
		BeanUtils.copyProperties(updateProduct, updatedProduct);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updatedProduct;
	}

	@Override
	public Products removeProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products deletedProduct = manager.find(Products.class, productId);
		manager.remove(deletedProduct);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deletedProduct;
	}

	@Override
	public List<Products> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Products> query = manager.createQuery("FROM Products", Products.class);
		return query.getResultList();
	}

	@Override
	public Products getProductById(int productId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products product = manager.find(Products.class, productId);
		return product;
	}
}