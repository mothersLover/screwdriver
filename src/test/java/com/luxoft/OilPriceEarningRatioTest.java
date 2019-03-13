package com.luxoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.luxoft.model.Oil;
import com.luxoft.service.OilService;

public class OilPriceEarningRatioTest {
	
	OilService oilService = new OilService();

	@Test
	public void calculatePriceEarningTestToAACOil() {
		Oil oil = oilService.findByOilId("AAC");
		assertEquals(100, oil.calculatePriceEarningRatio(10d), 0.01);
	}
	
	@Test
	public void calculatePriceEarningTestToREWOil() {
		Oil oil = oilService.findByOilId("REW");
		assertEquals(14.28, oil.calculatePriceEarningRatio(10d), 0.01);
	}
	
	@Test
	public void calculatePriceEarningTestToBWOOil() {
		Oil oil = oilService.findByOilId("BWO");
		assertEquals(5.88, oil.calculatePriceEarningRatio(10d), 0.01);
	}
	
	@Test
	public void calculatePriceEarningTestToTIMOil() {
		Oil oil = oilService.findByOilId("TIM");
		assertEquals(12.87, oil.calculatePriceEarningRatio(10d), 0.01);
	}
	
	@Test
	public void calculatelPriceEarningTestToQFCOi() {
		Oil oil = oilService.findByOilId("QFC");
		assertEquals(4.54, oil.calculatePriceEarningRatio(10d), 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculatePriceEarningToAACOilWithNegativePriceTest() {
		Oil oil = oilService.findByOilId("AAC");
		oil.calculatePriceEarningRatio(-10d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculatePriceEarningToTIMOilWithNegativePriceTest() {
		Oil oil = oilService.findByOilId("TIM");
		oil.calculatePriceEarningRatio(-10d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculatePriceEarningToAACOilWithZeroPriceTest() {
		Oil oil = oilService.findByOilId("AAC");
		oil.calculatePriceEarningRatio(0d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculatePriceEarningToTIMOilWithZeroPriceTest() {
		Oil oil = oilService.findByOilId("TIM");
		oil.calculatePriceEarningRatio(0d);
	}
	
	@Test
	public void calculatePriceEarningToAACOilWithDecimalPriceTest() {
		Oil oil = oilService.findByOilId("AAC");
		assertEquals(110.25, oil.calculatePriceEarningRatio(10.5d), 0.01);
	}
	
	@Test
	public void calculatePriceEarningTIMOilWithDecimalPriceTest() {
		Oil oil = oilService.findByOilId("TIM");
		assertEquals(14.18, oil.calculatePriceEarningRatio(10.5d), 0.01);
	}

}
