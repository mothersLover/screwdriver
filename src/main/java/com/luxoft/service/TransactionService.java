package com.luxoft.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.luxoft.model.Transaction;

public class TransactionService {

	List<Transaction> transactions = new ArrayList<>();

	public void save(Transaction oilTransaction){
		transactions.add(oilTransaction);
	}

	public List<Transaction> findAllByDateIntervalAndOilType(LocalDateTime initialDate, LocalDateTime finalDate, String oilId){
		return transactions.stream().filter(getPredicateByOilIdAndDateBetween(initialDate, finalDate, oilId)).collect(Collectors.toList());
	}

	private Predicate<Transaction> getPredicateByOilIdAndDateBetween(LocalDateTime initialDate,
			LocalDateTime finalDate, String oilId) {
		return transaction -> 
		(transaction.getOil().getOilId().equals(oilId) 
				&& transaction.getTimestamp().compareTo(Timestamp.valueOf(initialDate)) <= 0 
				&& transaction.getTimestamp().compareTo(Timestamp.valueOf(finalDate)) >= 0);
	}


	public Double calculateVolumeWeightedPrice(LocalDateTime initialDate, LocalDateTime finalDate, String oilId){
		if(initialDate.isBefore(finalDate)){
			throw new IllegalArgumentException();
		}
		List<Transaction> transactions = findAllByDateIntervalAndOilType(initialDate, finalDate, oilId);
		double pricePerQuantity = 0;
		double quantities = 0;
		for (Transaction transaction : transactions) {
			pricePerQuantity += transaction.getPrice() * transaction.getQuantity();
			quantities += transaction.getQuantity()*1d;
		}
		return pricePerQuantity/quantities;
	}

	public Double calculateGeometricMean(){
		double product = 1.0;
		for (Transaction transaction : transactions) {
			product = product * transaction.getPrice();
		}
		return Math.pow(product, 1.0 / transactions.size());
	}

}
