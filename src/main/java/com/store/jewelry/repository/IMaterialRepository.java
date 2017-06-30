package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.Material;

public interface IMaterialRepository {
	
	public List<Material> getMaterial();
	
	public List<Material> availableMaterialByParameter(String productCategory);

}
