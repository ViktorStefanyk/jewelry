package com.store.jewelry.domain;

public class Gender {
	
	public Integer genderId;
	public String genderLink;
	public String genderName;
	public Integer quantityGender;
	public Gender() {
		super();
	}
	public Integer getGenderId() {
		return genderId;
	}
	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}
	public String getGenderLink() {
		return genderLink;
	}
	public void setGenderLink(String genderLink) {
		this.genderLink = genderLink;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public Integer getQuantityGender() {
		return quantityGender;
	}
	public void setQuantityGender(Integer quantityGender) {
		this.quantityGender = quantityGender;
	}
	

}
