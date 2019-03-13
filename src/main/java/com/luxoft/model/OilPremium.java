package com.luxoft.model;

public class OilPremium extends Oil {

	private Double variableRevenue;

	public OilPremium(String oilId, Double fixedRevenue, Double variableRevenue, Double oilBarrelValue) {
		super(oilId, OilType.PREMIUM, fixedRevenue, oilBarrelValue);
		this.variableRevenue = variableRevenue;
	}

	public Double getVariableRevenue() {
		return variableRevenue;
	}

	@Override
	public Double calculateRevenueYield(Double price) {
		if (getVariableRevenue() != null && getOilBarrelValue() != null && price != null && getVariableRevenue() > 0
				&& getOilBarrelValue() > 0 && price > 0) {
			return (((getVariableRevenue() / 100) * getOilBarrelValue()) / price);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
