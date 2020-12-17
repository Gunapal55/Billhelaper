package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billhelper.dao.BundleDAO;
import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;
import com.onebill.billhelper.exception.BillhelperException;

@Service
public class BundleServiceImplementation implements BundleService {

	@Autowired
	private BundleDAO bundledao;

	@Override
	public Bundle createBundle(Bundle bundle) {
	
		Bundle addBundle = bundledao.createBundle(bundle);
		if (addBundle != null) {
			return addBundle;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public Bundle updateBundle(Bundle bundle) {
		Bundle updateBundle = bundledao.updateBundle(bundle);
		if (updateBundle != null) {

			return updateBundle;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public Bundle removeBundle(int bundleId) {
		Bundle removeBundle = bundledao.removeBundle(bundleId);
		if (removeBundle != null) {

			return removeBundle;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public List<Bundle> getAllBundle() {
		List<Bundle> bundleList = bundledao.getAllBundle();
		if (bundleList!= null) {

			return bundleList;

		} else {
			throw new BillhelperException("No plans found");

		}
	}

	@Override
	public BundleDetails addBundleDetails(BundleDetails bundleDetail) {

		BundleDetails addBundleDetail = bundledao.addBundleDetails(bundleDetail);
		if (addBundleDetail != null) {
			return addBundleDetail;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public BundleDetails updateBundleDetails(BundleDetails bundleDetail) {
		BundleDetails updateBundleDetail = bundledao.updateBundleDetails(bundleDetail);
		if (updateBundleDetail != null) {

			return updateBundleDetail;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public BundleDetails removeBundleDetails(int bundleDetailId) {
		BundleDetails removeBundleDetail = bundledao.removeDetails(bundleDetailId);
		if (removeBundleDetail != null) {

			return removeBundleDetail;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public List<BundleDetails> getAllBundleDetails() {
		List<BundleDetails> bundleDetailList = bundledao.getAllBundleDetails();
		if (bundleDetailList != null) {

			return bundleDetailList;

		} else {
			throw new BillhelperException("No plans found");

		}
	}

	@Override
	public Bundle getBundleById(int bundleId) {
		Bundle bundle = bundledao.getBundleById(bundleId);
		if (bundle!= null) {
			return bundle;

		} else {
			throw new BillhelperException("No plans found");

		}
	}

	@Override
	public BundleDetails getBundleDetailById(int bundleDetailId) {
		BundleDetails bundleDetail = bundledao.getBundleDetailById(bundleDetailId);
		if (bundleDetail!= null) {
			return bundleDetail;

		} else {
			throw new BillhelperException("No plans found");

		}	
	}
}
