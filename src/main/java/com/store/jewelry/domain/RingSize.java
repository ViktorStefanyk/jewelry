package com.store.jewelry.domain;

public class RingSize {
	
	public Integer ringSizeId;
	public Float ringSize;
	public Integer quantityRingSize;
	public boolean ringSizeFlag;
	public RingSize() {
		super();
	}
	public Integer getRingSizeId() {
		return ringSizeId;
	}
	public void setRingSizeId(Integer ringSizeId) {
		this.ringSizeId = ringSizeId;
	}
	public Float getRingSize() {
		return ringSize;
	}
	public void setRingSize(Float ringSize) {
		this.ringSize = ringSize;
	}
	public Integer getQuantityRingSize() {
		return quantityRingSize;
	}
	public void setQuantityRingSize(Integer quantityRingSize) {
		this.quantityRingSize = quantityRingSize;
	}
	public boolean isRingSizeFlag() {
		return ringSizeFlag;
	}
	public void setRingSizeFlag(boolean ringSizeFlag) {
		this.ringSizeFlag = ringSizeFlag;
	}
	
}
