package com.luxoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.luxoft.model.Oil;
import com.luxoft.service.OilService;

public class OilRevenueYieldTest {
	
	OilService oilService = new OilService();

	@Test
	public void calculateRevenueYieldTestToAACOil() {
		Oil oil = oilService.findByOilId("AAC");
		assertEquals(0.1, oil.calculateRevenueYield(10d), 0.01);
	}
	
	@Test
	public void calculateRevenueYieldToREWOilTest() {
		Oil oil = oilService.findByOilId("REW");
		assertEquals(0.7, oil.calculateRevenueYield(10d), 0.01);
	}
	
	@Test
	public void calculateRevenueYieldToBWOilTest() {
		Oil oil = oilService.findByOilId("BWO");
		assertEquals(1.7, oil.calculateRevenueYield(10d), 0.01);
	}
	
	@Test
	public void calculateRevenueYieldToTIMOilTest() {
		Oil oil = oilService.findByOilId("TIM");
		assertEquals(0.77, oil.calculateRevenueYield(10d), 0.01);
	}
	
	@Test
	public void calculateRevenueYieldToQFCOilTest() {
		Oil oil = oilService.findByOilId("QFC");
		assertEquals(2.2, oil.calculateRevenueYield(10d), 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateRevenueYieldToAACOilWithNegativePriceTest() {
		Oil oil = oilService.findByOilId("AAC");
		oil.calculateRevenueYield(-10d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateRevenueYieldToTIMOilWithNegativePriceTest() {
		Oil oil = oilService.findByOilId("TIM");
		oil.calculateRevenueYield(-10d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateRevenueYieldToAACOilWithZeroPriceTest() {
		Oil oil = oilService.findByOilId("AAC");
		oil.calculateRevenueYield(0d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateRevenueYieldToTIMOilWithZeroPriceTest() {
		Oil oil = oilService.findByOilId("TIM");
		oil.calculateRevenueYield(0d);
	}
	
	@Test
	public void calculateRevenueYielToAACOildWithDecimalPriceTest() {
		Oil oil = oilService.findByOilId("AAC");
		assertEquals(0.1, oil.calculateRevenueYield(10.5d), 0.01);
	}
	
	@Test
	public void calculateRevenueYielToTIMOildWithDecimalPriceTest() {
		Oil oil = oilService.findByOilId("TIM");
		assertEquals(0.74, oil.calculateRevenueYield(10.5d), 0.01);
	}

}
