package com.store.jewelry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.jewelry.domain.Category;
import com.store.jewelry.domain.ChainsSize;
import com.store.jewelry.domain.Gemstone;
import com.store.jewelry.domain.Gender;
import com.store.jewelry.domain.Material;
import com.store.jewelry.domain.PendantSize;
import com.store.jewelry.domain.Product;
import com.store.jewelry.domain.RingSize;
import com.store.jewelry.domain.Type;
import com.store.jewelry.repository.IAddProductRepository;
import com.store.jewelry.repository.ICategoryRepository;
import com.store.jewelry.repository.IChainsSizeRepository;
import com.store.jewelry.repository.IFilterProductRepository;
import com.store.jewelry.repository.IGemstoneRepository;
import com.store.jewelry.repository.IGenderRepository;
import com.store.jewelry.repository.IImageRepository;
import com.store.jewelry.repository.IMaterialRepository;
import com.store.jewelry.repository.IPendantSizeRepository;
import com.store.jewelry.repository.IProductRepository;
import com.store.jewelry.repository.IRingSizeRepository;
import com.store.jewelry.repository.ITypeRepository;
import com.store.jewelry.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired public IProductRepository productRepository;
	@Autowired public IGemstoneRepository gemstoneRepository;
	@Autowired public ICategoryRepository categoryRepository;
	@Autowired public IMaterialRepository materialRepository;
	@Autowired public ITypeRepository typeRepository;
	@Autowired public IRingSizeRepository ringRepository;
	@Autowired public IChainsSizeRepository chainsRepository;
	@Autowired public IAddProductRepository addProductRepository;
	@Autowired public IImageRepository imageRepository;
	@Autowired public IFilterProductRepository filterProductRepository;
	@Autowired public IPendantSizeRepository pendantRepository;
	@Autowired public IGenderRepository genderRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public List<Gemstone> getGemstones() {
		return gemstoneRepository.getGemstones();
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepository.getCategories();
	}

	@Override
	public List<Material> getMaterial() {
		return materialRepository.getMaterial();
	}

	@Override
	public List<Type> getTypes() {
		return typeRepository.getTypes();
	}

	@Override
	public List<RingSize> getAllRingSizes() {
		return ringRepository.getAllRingSizes();
	}

	@Override
	public List<ChainsSize> getAllChainsSizes() {
		return chainsRepository.getAllChainsSizes();
	}

	@Override
	public void addProduct(Product product) {
		addProductRepository.addProduct(product);
		for (RingSize ringSize : product.getProductRingSizes()) {
			if (ringSize != null && ringSize.isRingSizeFlag()) {
				ringRepository.addRingSizes(product.getProductId(), ringSize.getRingSizeId());
			}
		}
		
		for (ChainsSize chainsSize : product.getProductChainsSizes()) {
			if (chainsSize != null && chainsSize.isChainsSizeFlag()) {
				chainsRepository.addChainsSizes(product.getProductId(), chainsSize.getChainsSizeId());
			}
		}
		for (PendantSize pendantSize : product.getProductPendantSizes()) {
			if (pendantSize != null && pendantSize.isPendantSizeFlag()) {
				pendantRepository.addPendantSizes(product.getProductId(), pendantSize.getPendantSizeId());
			}
		}
		
	}

	@Override
	public void addMainImage(Integer productId, String imageName, String imageRole) {
		imageRepository.addMainImage(productId, imageName, imageRole);
	}

	@Override
	public List<Product> getProductsByParameter(String productCategory, List<Integer> productGemstones, 
			List<Integer> productType, List<Integer> productMaterial,
			Integer productMinPrice, Integer productMaxPrice,
			List<Integer> sizeRing, List<Integer> sizeChains,
			List<Integer> sizePendant, Integer productGender) {
		return filterProductRepository.getProductsByParameter(productCategory, productGemstones, productType, productMaterial, productMinPrice, productMaxPrice, sizeRing, sizeChains, sizePendant, productGender);
	}

	@Override
	public List<RingSize> availableRingSizeByParameters(String productCategory) {
		return ringRepository.availableRingSizeByParameters(productCategory);
	}

	@Override
	public List<ChainsSize> availableChainsSizeByParameters(String productCategory) {
		return chainsRepository.availableChainsSizeByParameters(productCategory);
	}

	@Override
	public List<Gemstone> availableGemstoneByParameter(String productCategory) {
		return gemstoneRepository.availableGemstoneByParameter(productCategory);
	}

	@Override
	public List<Material> availableMaterialByParameter(String productCategory) {
		return materialRepository.availableMaterialByParameter(productCategory);
	}

	@Override
	public List<Type> availableTypeByParameter(String productCategory) {
		return typeRepository.availableTypeByParameter(productCategory);
	}

	@Override
	public List<PendantSize> getAllPendantSizes() {
		return pendantRepository.getAllPendantSizes();
	}

	@Override
	public List<PendantSize> availablePendantByParameter(String productCategory) {
		return pendantRepository.availablePendantByParameter(productCategory);
	}

	@Override
	public List<Gender> getGenders() {
		return genderRepository.getGenders();
	}

	@Override
	public List<Gender> availableGenderByParameter(String productCategory) {
		return genderRepository.availableGenderByParameter(productCategory);
	}

}
