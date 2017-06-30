package com.store.jewelry.repository;

import java.util.List;

import com.store.jewelry.domain.Category;

public interface ICategoryRepository {
	
	public List<Category> getCategories();

}
