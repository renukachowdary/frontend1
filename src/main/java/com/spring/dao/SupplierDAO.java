package com.spring.dao;

import java.util.List;

import com.spring.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
    public List<Supplier> retrieveSupplier();
    public boolean deleteSupplier(int supId);
    public Supplier getSupplier(int supId);
    public boolean updateSupplier(int supId);

}