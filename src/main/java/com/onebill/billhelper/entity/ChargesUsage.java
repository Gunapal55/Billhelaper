package com.onebill.billhelper.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Extra_Charges")
@Data
public class ChargesUsage {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int chargeId;
	
	private int chargeAmount;
	
	private String ChargeType;
	
	private String Document;
		
}
