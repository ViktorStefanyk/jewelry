package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.PendantSize;

public interface IPendantSizeRepository {
	
	public List<PendantSize> getAllPendantSizes();
	
	public void addPendantSizes(Integer productId, Integer pendantSizeId);
	
	public List<PendantSize> availablePendantByParameter(String productCategory);
	

}
