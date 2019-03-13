package com.luxoft.model;

public abstract class Oil {

	private String oilId;
	private Double fixedRevenue;
	private Double oilBarrelValue;
	private OilType oilType;

	protected Oil(String oilId, OilType oilType, Double fixedRevenue, Double oilBarrelValue) {
		this.oilId = oilId;
		this.fixedRevenue = fixedRevenue;
		this.oilBarrelValue = oilBarrelValue;
		this.oilType = oilType;
	}

	public String getOilId() {
		return oilId;
	}

	public Double getFixedRevenue() {
		return fixedRevenue;
	}

	public Double getOilBarrelValue() {
		return oilBarrelValue;
	}

	public OilType getOilType() {
		return oilType;
	}

	public abstract Double calculateRevenueYield(Double price);

	public Double calculatePriceEarningRatio(Double price) {
		Double revenue = calculateRevenueYield(price);
		if (price != null && price > 0) {
			return price / revenue;
		} else {
			throw new IllegalArgumentException();
		}
	}

	

}
