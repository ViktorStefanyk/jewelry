package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.Type;

public interface ITypeRepository {
	
	public List<Type> getTypes();
	
	public List<Type> availableTypeByParameter(String productCategory);

}
