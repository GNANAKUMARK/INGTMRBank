package com.ing.tmrbank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.tmrbank.dao.TransactionDao;
import com.ing.tmrbank.dao.UserDao;
import com.ing.tmrbank.entity.Account;
import com.ing.tmrbank.entity.Transaction;

@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	UserDao userRepo;
	@Autowired
	TransactionDao repository;

	@Override
	public String saveTransaction(Transaction transaction) {

		Account account = userRepo.findAccountById(transaction.getUserId());
		if (account.getBalance() < transaction.getAmount()) {
			return "Insufficient Balance";
		} else {
			account.setBalance(account.getBalance() - transaction.getAmount());
			userRepo.save(account);
			transaction.setTransactionType("debit");
			repository.save(transaction);
			return "Saved Successfully";
		}

	}

	public List<Transaction> getTransactions(int id, String fromDate, String toDate) {

		return repository.findTransactionsById(id, fromDate, toDate);
	}
}
