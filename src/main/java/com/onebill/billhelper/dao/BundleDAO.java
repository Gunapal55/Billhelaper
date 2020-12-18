package com.onebill.billhelper.dao;

import java.util.List;

import com.onebill.billhelper.entity.AddtionalCharges;
import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;
import com.onebill.billhelper.entity.OverDue;

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

	public OverDue addOverDue(OverDue overDue);

	public OverDue updateOverDue(OverDue overDue);

	public OverDue deleteOverDue(int overDueId);

	public OverDue getOverDueById(int overDueId);

	public AddtionalCharges addAddtionalCharges(AddtionalCharges addtional);

	public AddtionalCharges updateAddtionalCharges(AddtionalCharges addtional);

	public AddtionalCharges deleteAddtionalCharges(int addtionalChargesId);

	public AddtionalCharges getAddtionalChargesById(int BundleId);

}
