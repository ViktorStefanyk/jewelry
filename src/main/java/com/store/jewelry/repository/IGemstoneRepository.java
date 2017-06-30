package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.Gemstone;

public interface IGemstoneRepository {
	
	public List<Gemstone> getGemstones();
	
	public List<Gemstone> availableGemstoneByParameter(String productCategory);

}
