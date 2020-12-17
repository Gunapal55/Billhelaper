package com.onebill.billhelper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;

@Repository
public class BundleDAOImplementation implements BundleDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public Bundle createBundle(Bundle bundle) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		manager.persist(bundle);
		manager.getTransaction().commit();
		manager.close();
		return bundle;

	}

	@Override
	public Bundle updateBundle(Bundle updateBundle) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Bundle updatedBundle = manager.find(Bundle.class, updateBundle.getBundleId());
		BeanUtils.copyProperties(updateBundle, updatedBundle);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updatedBundle;
	}

	@Override
	public Bundle removeBundle(int bundleId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Bundle deletedBundle = manager.find(Bundle.class, bundleId);
		manager.remove(deletedBundle);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deletedBundle;

	}

	@Override
	public List<Bundle> getAllBundle() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Bundle> query = manager.createQuery("FROM Bundle", Bundle.class);
		return query.getResultList();
	}

	@Override
	public BundleDetails addBundleDetails(BundleDetails bundleDetail) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		manager.persist(bundleDetail);
		manager.getTransaction().commit();
		manager.close();
		return bundleDetail;

	}

	@Override
	public BundleDetails updateBundleDetails(BundleDetails bundleDetail) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BundleDetails updatedBundleDetail = manager.find(BundleDetails.class, bundleDetail.getBundleDetailId());
		BeanUtils.copyProperties(bundleDetail, updatedBundleDetail);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updatedBundleDetail;
	}

	@Override
	public BundleDetails removeDetails(int bundleDetailId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BundleDetails deletedBundleDetail = manager.find(BundleDetails.class, bundleDetailId);
		manager.remove(deletedBundleDetail);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deletedBundleDetail;

	}

	@Override
	public List<BundleDetails> getAllBundleDetails() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<BundleDetails> query = manager.createQuery("FROM BundleDetails", BundleDetails.class);
		return query.getResultList();
	}

	@Override
	public Bundle getBundleById(int BundleId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Bundle bundle = manager.find(Bundle.class, BundleId);
		return bundle;
	}

	@Override
	public BundleDetails getBundleDetailById(int bundleDetailId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BundleDetails bundleDetail = manager.find(BundleDetails.class, bundleDetailId);
		return bundleDetail;

	}

}
