package com.store.jewelry.service;

import java.util.List;

import com.store.jewelry.domain.Category;
import com.store.jewelry.domain.ChainsSize;
import com.store.jewelry.domain.Gemstone;
import com.store.jewelry.domain.Gender;
import com.store.jewelry.domain.Material;
import com.store.jewelry.domain.PendantSize;
import com.store.jewelry.domain.Product;
import com.store.jewelry.domain.RingSize;
import com.store.jewelry.domain.Type;

public interface IProductService {
	
	public List<Product> getAllProducts();
	
	public List<Gemstone> getGemstones();
	
	public List<Gemstone> availableGemstoneByParameter(String productCategory);
	
	public List<Category> getCategories();
	
	public List<Material> getMaterial();
	
	public List<Material> availableMaterialByParameter(String productCategory);
	
	public List<Type> getTypes();
	
	public List<Type> availableTypeByParameter(String productCategory);
	
	public List<RingSize> getAllRingSizes();
	
	public List<ChainsSize> getAllChainsSizes();
	
	public void addProduct(Product product);
	
	public void addMainImage(Integer productId, String imageName, String imageRole);
	
	public List<Product> getProductsByParameter(String productCategory, List<Integer> productGemstones, 
			List<Integer> productType, List<Integer> productMaterial,
			Integer productMinPrice, Integer productMaxPrice,
			List<Integer> sizeRing, List<Integer> sizeChains,
			List<Integer> sizePendant, Integer productGender);	
	
	public List<RingSize> availableRingSizeByParameters(String productCategory);
	
	public List<ChainsSize> availableChainsSizeByParameters(String productCategory);
	
	public List<PendantSize> getAllPendantSizes();
	
	public List<PendantSize> availablePendantByParameter(String productCategory);
	
	public List<Gender> getGenders();
	
	public List<Gender> availableGenderByParameter(String productCategory);
	
	
}
