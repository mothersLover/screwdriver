package com.luxoft.factory;

import com.luxoft.model.Oil;
import com.luxoft.model.OilPremium;
import com.luxoft.model.OilStandard;
import com.luxoft.model.OilType;

public class OilFactory {
	public static Oil getOil(String oilId,OilType oilType, Double fixedRevenue, Double variableRevenue, Double oilBarrelValue) {
		switch (oilType) {
		case STANDARD:
			return new OilStandard(oilId, fixedRevenue, oilBarrelValue);
		case PREMIUM:
			return new OilPremium(oilId, fixedRevenue, variableRevenue, oilBarrelValue);
		}
		return null;
	}
}
