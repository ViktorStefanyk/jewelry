package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.RingSize;

public interface IRingSizeRepository {
	
	public List<RingSize> getAllRingSizes();
	
	public void addRingSizes(Integer productId, Integer ringSizeId);
	
	public List<RingSize> availableRingSizeByParameters(String productCategory);
	

}
