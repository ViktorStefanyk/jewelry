package com.store.jewelry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.store.jewelry.domain.Category;
import com.store.jewelry.domain.ChainsSize;
import com.store.jewelry.domain.Gemstone;
import com.store.jewelry.domain.Gender;
import com.store.jewelry.domain.Material;
import com.store.jewelry.domain.PendantSize;
import com.store.jewelry.domain.Product;
import com.store.jewelry.domain.RingSize;
import com.store.jewelry.domain.Type;
import com.store.jewelry.service.IProductService;

@Controller
@RequestMapping(value="/")
public class UserController {
	
	@Autowired
	public IProductService productService;
	
	@RequestMapping(value={"/all", "/"}, method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		ModelAndView model = new ModelAndView();
		List<Product> list = productService.getAllProducts();
		model.addObject("products", list);
		model.setViewName("main");
		return model;
	}
	
	@RequestMapping(value="all/{category}", method=RequestMethod.GET)
	public ModelAndView filterByCategory(@PathVariable("category") String productCategory,
											@RequestParam(value="gemstones", required=false) List<Integer> productGemstones,
											@RequestParam(value="types", required=false) List<Integer> productType,
											@RequestParam(value="materials", required=false) List<Integer> productMaterial,
											@RequestParam(value="minprice", required=false) Integer productMinPrice,
											@RequestParam(value="maxprice", required=false) Integer productMaxPrice,
											@RequestParam(value="sizering", required=false) List<Integer> sizeRing,
											@RequestParam(value="sizechains", required=false) List<Integer> sizeChains,
											@RequestParam(value="sizependant", required=false) List<Integer> sizePendant,
											@RequestParam(value="gender", required=false) Integer productGender) {
		ModelAndView model = new ModelAndView();
		List<Product> productList  = productService.getProductsByParameter(productCategory, productGemstones, productType, productMaterial, productMinPrice, productMaxPrice, sizeRing, sizeChains, sizePendant, productGender);
		List<Category> categoryList = productService.getCategories();
		List<Gemstone> gemstoneList = productService.availableGemstoneByParameter(productCategory);
		List<Material> materialList = productService.availableMaterialByParameter(productCategory);
		List<Type> typeList = productService.availableTypeByParameter(productCategory);
		List<RingSize> ringSizeList = productService.availableRingSizeByParameters(productCategory);
		List<ChainsSize> chainsSizeList = productService.availableChainsSizeByParameters(productCategory);
		List<PendantSize> pendantSizeList = productService.availablePendantByParameter(productCategory);
		List<Gender> genderList = productService.availableGenderByParameter(productCategory);
			
		model.addObject("products", productList);
		
		model.addObject("productCategory", productCategory);
		
		
		model.addObject("productGemstones", productGemstones);
		model.addObject("productType", productType);
		model.addObject("productMaterial", productMaterial);
		model.addObject("productGender", productGender);
		model.addObject("productSizeRing", sizeRing);
		model.addObject("productSizeChains", sizeChains);
		model.addObject("productSizePendant", sizePendant);
		if(productMinPrice != null) {
			model.addObject("productMinPrice", productMinPrice);
		}
		
		if (productMaxPrice != null) {
			model.addObject("productMaxPrice", productMaxPrice);
		}
		
		model.addObject("genders", genderList);
		model.addObject("pendantSizes", pendantSizeList);
		model.addObject("chainsSizes", chainsSizeList);
		model.addObject("ringSizes", ringSizeList);
		model.addObject("categories", categoryList);
		model.addObject("gemstones", gemstoneList);
		model.addObject("materials", materialList);
		model.addObject("types", typeList);
		model.setViewName("filterPage");
		return model;
	}

}
