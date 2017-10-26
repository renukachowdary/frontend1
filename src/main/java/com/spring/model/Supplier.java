package com.spring.model;

import javax.persistence.*;

@Entity
public class Supplier 
{
	

	@Id
	@GeneratedValue
	
	int supId;
	
	String supName,supDesc, supAddress;

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupDesc() {
		return supDesc;
	}

	public void setSupDesc(String supDesc) {
		this.supDesc = supDesc;
	}

	public String getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}



	
	
}