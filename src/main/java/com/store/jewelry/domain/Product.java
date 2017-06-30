package com.store.jewelry.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	public Integer productId;
	public String productName;
	public String productDescription;
	public String productType;
	public String productCategory;
	public Integer productPrice;
	public Integer productMinPrice;
	public Integer productMaxPrice;
	public String productGemstone;
	public String productMaterial;
	public Integer productQuantityParameters;
	public Float productWeight;
	public String productGender;
	public List<RingSize> productRingSizes;
	public List<ChainsSize> productChainsSizes;
	public List<PendantSize> productPendantSizes;
	public MultipartFile productMainImage;
	public List<MultipartFile> productAdditionalImages;
	public String productImageName;
	
	public Product() {
		super();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductGemstone() {
		return productGemstone;
	}

	public void setProductGemstone(String productGemstone) {
		this.productGemstone = productGemstone;
	}

	public String getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	public Float getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(Float productWeight) {
		this.productWeight = productWeight;
	}

	public List<RingSize> getProductRingSizes() {
		return productRingSizes;
	}

	public void setProductRingSizes(List<RingSize> productRingSizes) {
		this.productRingSizes = productRingSizes;
	}

	public List<ChainsSize> getProductChainsSizes() {
		return productChainsSizes;
	}

	public void setProductChainsSizes(List<ChainsSize> productChainsSizes) {
		this.productChainsSizes = productChainsSizes;
	}

	public MultipartFile getProductMainImage() {
		return productMainImage;
	}

	public void setProductMainImage(MultipartFile productMainImage) {
		this.productMainImage = productMainImage;
	}

	public List<MultipartFile> getProductAdditionalImages() {
		return productAdditionalImages;
	}

	public void setProductAdditionalImages(List<MultipartFile> productAdditionalImages) {
		this.productAdditionalImages = productAdditionalImages;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public Integer getProductQuantityParameters() {
		return productQuantityParameters;
	}

	public void setProductQuantityParameters(Integer productQuantityParameters) {
		this.productQuantityParameters = productQuantityParameters;
	}
	
	public Integer getProductMinPrice() {
		return productMinPrice;
	}

	public void setProductMinPrice(Integer productMinPrice) {
		this.productMinPrice = productMinPrice;
	}

	public Integer getProductMaxPrice() {
		return productMaxPrice;
	}

	public void setProductMaxPrice(Integer productMaxPrice) {
		this.productMaxPrice = productMaxPrice;
	}

	public List<PendantSize> getProductPendantSizes() {
		return productPendantSizes;
	}

	public void setProductPendantSizes(List<PendantSize> productPendantSizes) {
		this.productPendantSizes = productPendantSizes;
	}

	public String getProductGender() {
		return productGender;
	}

	public void setProductGender(String productGender) {
		this.productGender = productGender;
	}
	
	

}
