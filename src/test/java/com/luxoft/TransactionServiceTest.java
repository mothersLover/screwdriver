package com.luxoft;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.luxoft.model.Oil;
import com.luxoft.model.Transaction;
import com.luxoft.model.TransactionType;
import com.luxoft.service.OilService;
import com.luxoft.service.TransactionService;

import junit.framework.Assert;

public class TransactionServiceTest {
	
	TransactionService transactionService = new TransactionService();
	OilService oilService = new OilService();

	@Before
	public void createTransactions(){
		
		List<Oil> oils = oilService.listAll();
		
		for (Oil oil : oils) {
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime halfHour = now.minus(30l,ChronoUnit.MINUTES);
			LocalDateTime endTime = now.minus(1l,ChronoUnit.HOURS);
			while (now.isAfter(endTime)) {
				if(now.isBefore(halfHour)){
					transactionService.save(new Transaction(Timestamp.valueOf(now), oil, 1, TransactionType.BUY, 3d));
					transactionService.save(new Transaction(Timestamp.valueOf(now), oil, 2, TransactionType.SELL, 2d));
				} else {
					transactionService.save(new Transaction(Timestamp.valueOf(now), oil, 10, TransactionType.BUY, 100d));
					transactionService.save(new Transaction(Timestamp.valueOf(now), oil, 20, TransactionType.SELL, 200d));
				}
				now = now.minus(10l, ChronoUnit.MINUTES);
			}
		}
	}
	
	@Test
	public void calculateVolumeWeightedPriceToAACOilLast30MinutesTest(){
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime endTime = now.minus(30l,ChronoUnit.MINUTES);
		Double volumeWeighterPrice = transactionService.calculateVolumeWeightedPrice(now, endTime, "AAC");
		Assert.assertEquals(166.66, volumeWeighterPrice, 0.01);
	}
	
	@Test
	public void calculateVolumeWeightedPriceToAACOilLast1HourTest(){
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime endTime = now.minus(60l,ChronoUnit.MINUTES);
		Double volumeWeighterPrice = transactionService.calculateVolumeWeightedPrice(now, endTime, "AAC");
		Assert.assertEquals(158.84, volumeWeighterPrice, 0.01);
	}
	
	
	@Test
	public void calculateVolumeWeightedPriceToTIMOilLast30MinutesTest(){
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime endTime = now.minus(30l,ChronoUnit.MINUTES);
		Double volumeWeighterPrice = transactionService.calculateVolumeWeightedPrice(now, endTime, "TIM");
		Assert.assertEquals(166.66, volumeWeighterPrice, 0.01);
	}
	
	@Test
	public void calculateVolumeWeightedPriceToTIMOilLast1HourTest(){
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime endTime = now.minus(60l,ChronoUnit.MINUTES);
		Double volumeWeighterPrice = transactionService.calculateVolumeWeightedPrice(now, endTime, "TIM");
		Assert.assertEquals(158.84, volumeWeighterPrice, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateVolumeWeightedPriceInvalidDateIntervalTest(){
		LocalDateTime endTime = LocalDateTime.now();
		LocalDateTime now = endTime.minus(30l,ChronoUnit.MINUTES);
		transactionService.calculateVolumeWeightedPrice(now, endTime, "AAC");
	}
	
	
	@Test
	public void calculateGeometricMeanTest(){
		Double volumeWeighterPrice = transactionService.calculateGeometricMean();
		Assert.assertEquals(36.59, volumeWeighterPrice, 0.01);
	}
	
}
