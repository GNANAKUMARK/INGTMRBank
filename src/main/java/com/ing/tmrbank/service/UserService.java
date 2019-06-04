package com.ing.tmrbank.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ing.tmrbank.entity.Account;
import com.ing.tmrbank.pojo.SaveAccountRequest;
import com.ing.tmrbank.pojo.SaveAccountResponse;
import com.ing.tmrbank.pojo.UpdateAccountRequest;

public interface UserService {
	public SaveAccountResponse saveAccount(SaveAccountRequest request);
	public SaveAccountResponse updateAccount(@RequestBody UpdateAccountRequest request);
	public List<Account> findAll();
	Account getAccountById(int id);

}
