package com.luxoft.model;

public class OilStandard extends Oil {

	public OilStandard(String oilId, Double fixedRevenue, Double oilBarrelValue) {
		super(oilId,OilType.STANDARD, fixedRevenue, oilBarrelValue);
	}

	@Override
	public Double calculateRevenueYield(Double price) {
		if (getFixedRevenue() != null && price != null && getFixedRevenue() > 0 && price > 0) {
			return (getFixedRevenue() / price);
		} else {
			throw new IllegalArgumentException();
		}
	}

}
