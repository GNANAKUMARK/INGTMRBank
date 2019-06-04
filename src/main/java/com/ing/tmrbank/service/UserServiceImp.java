package com.ing.tmrbank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.tmrbank.dao.UserDao;
import com.ing.tmrbank.entity.Account;
import com.ing.tmrbank.pojo.SaveAccountRequest;
import com.ing.tmrbank.pojo.SaveAccountResponse;
import com.ing.tmrbank.pojo.UpdateAccountRequest;
import com.ing.tmrbank.utils.UtilConstants;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserDao repo;

	@Override
	public SaveAccountResponse saveAccount(SaveAccountRequest request) {
		SaveAccountResponse response = new  SaveAccountResponse();
		Account account = new Account();
		account.setAccountType(request.getAccType());
		account.setBalance(UtilConstants.DEFAULT_ACC_BALANCE);
		account.setEmailId(request.getEmail_id());
		account.setFirstName(request.getfName());
		account.setLastName(request.getlName());
		account.setMobile(request.getMobile());
		account.setPan(request.getPanCard_no());
		account.setPassword(request.getPassword());
		account.setStatus(UtilConstants.DEFAULT_STATUS);
		account.setUserName(request.getUserName());
		 account = repo.save(account);
		response.setUserId(account.getId());
		return response;
	}

	@Override
	public SaveAccountResponse updateAccount(UpdateAccountRequest request) {
		SaveAccountResponse response = new  SaveAccountResponse();
		repo.updateAccount(request.getUserId(), request.getStatus());
		return response;
	}

	//@Override
	 public List<Account> findAll() {
	  return repo.findAll();
	 }
	 
	 public Account getAccountById(int id) {
			
			return repo.findAccountById(id);
		}


}
