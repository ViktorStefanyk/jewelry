package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.Gender;

public interface IGenderRepository {
	
	public List<Gender> getGenders();
	
	public List<Gender> availableGenderByParameter(String productCategory);

}
