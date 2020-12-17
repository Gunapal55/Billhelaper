package com.onebill.billhelper.dao;

import java.util.List;

import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;

public interface BundleDAO {

	public Bundle createBundle(Bundle bundle);

	public Bundle updateBundle(Bundle bundle);

	public Bundle removeBundle(int bundleId);

	public List<Bundle> getAllBundle();

	public Bundle getBundleById(int BundleId);
	
	public BundleDetails addBundleDetails(BundleDetails bundleDetail);

	public BundleDetails updateBundleDetails(BundleDetails bundleDetail);

	public BundleDetails removeDetails(int bundleDetailId);

	public List<BundleDetails> getAllBundleDetails();
	
	public BundleDetails getBundleDetailById(int bundleDetailId);

	
	
}
