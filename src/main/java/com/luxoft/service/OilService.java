package com.luxoft.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.luxoft.factory.OilFactory;
import com.luxoft.model.Oil;
import com.luxoft.model.OilType;

public class OilService {
	
	private static Map<String,Oil> mapOil = new HashMap<String,Oil>();
	
	static {
		mapOil.put("AAC", OilFactory.getOil("AAC", OilType.STANDARD, 1d, null, 42d));
		mapOil.put("REW", OilFactory.getOil("REW", OilType.STANDARD, 7d, null, 47d));
		mapOil.put("BWO", OilFactory.getOil("BWO", OilType.STANDARD, 17d, null, 61d));
		mapOil.put("TIM", OilFactory.getOil("TIM", OilType.PREMIUM, 5d, 7d, 111d));
		mapOil.put("QFC", OilFactory.getOil("QFC", OilType.STANDARD, 22d, null, 123d));
	}
	
	public Oil findByOilId(String oilId){
		return mapOil.get(oilId);
	}
	
	public List<Oil> listAll(){
		return mapOil.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
	}

}
