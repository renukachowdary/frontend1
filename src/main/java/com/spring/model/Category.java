package com.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
@Table
public class Category 
{
    @Id
    @GeneratedValue
    int catId;
    @NotNull
    @Size(min=7,max=17)
    private String catName;
    @NotNull
    @Size(min=12,max=40)
    String catDesc;
    public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}


 
    
     
}