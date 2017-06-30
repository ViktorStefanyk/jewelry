package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.ChainsSize;

public interface IChainsSizeRepository {
	
	public List<ChainsSize> getAllChainsSizes();
	
	public void addChainsSizes(Integer productId, Integer chainsSizeId);
	
	public List<ChainsSize> availableChainsSizeByParameters(String productCategory);

}
