package com.ing.tmrbank.service;

import java.util.List;

import com.ing.tmrbank.entity.Transaction;

public interface FundTransferService {

	String saveTransaction(Transaction transaction);


	List<Transaction> getTransactions(int id, String fromDate, String toDate);

}
