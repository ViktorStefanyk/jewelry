package com.store.jewelry.domain;

public class PendantSize {
	
	public Integer pendantSizeId;
	public Float pendantSize;
	public boolean pendantSizeFlag;
	public Integer quantityPendantSize;
	public PendantSize() {
		super();
	}
	public Integer getPendantSizeId() {
		return pendantSizeId;
	}
	public void setPendantSizeId(Integer pendantSizeId) {
		this.pendantSizeId = pendantSizeId;
	}
	public Float getPendantSize() {
		return pendantSize;
	}
	public void setPendantSize(Float pendantSize) {
		this.pendantSize = pendantSize;
	}
	public boolean isPendantSizeFlag() {
		return pendantSizeFlag;
	}
	public void setPendantSizeFlag(boolean pendantSizeFlag) {
		this.pendantSizeFlag = pendantSizeFlag;
	}
	public Integer getQuantityPendantSize() {
		return quantityPendantSize;
	}
	public void setQuantityPendantSize(Integer quantityPendants) {
		this.quantityPendantSize = quantityPendants;
	}
}
