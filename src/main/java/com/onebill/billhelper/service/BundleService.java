package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;

@Service
public interface BundleService {

	public Bundle createBundle(Bundle bundle);

	public Bundle updateBundle(Bundle bundle);

	public Bundle removeBundle(int bundleId);

	public List<Bundle> getAllBundle();

	public Bundle getBundleById(int bundleId);
	
	public BundleDetails addBundleDetails(BundleDetails bundleDetail);

	public BundleDetails updateBundleDetails(BundleDetails bundleDetail);

	public List<BundleDetails> getAllBundleDetails();

	public BundleDetails removeBundleDetails(int bundleDetailId);

	public BundleDetails getBundleDetailById(int bundleDetailId);

}
