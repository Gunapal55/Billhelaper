package com.onebill.billhelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "bndl_details")
public class BundleDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bundleDetailId;
	
	@Column(name = "bdnle_type")
	private String bundleType;

	@Column(name = "bndl_details")
	private String bundleDetails;

	@Column(name = "req_docs")
	private String requiredDocuments;
	
	@ManyToOne
	@JoinColumn(name="bundle_id")
	private Bundle bundle;
		
}
