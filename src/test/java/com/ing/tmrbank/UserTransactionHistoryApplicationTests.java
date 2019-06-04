package com.ing.tmrbank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.tmrbank.SwaggerConfig;
import com.ing.tmrbank.UserTransactionHistoryApplication;
import com.ing.tmrbank.dao.TransactionDao;
import com.ing.tmrbank.dao.UserDao;
import com.ing.tmrbank.entity.Account;
import com.ing.tmrbank.entity.Transaction;
import com.ing.tmrbank.pojo.SaveAccountRequest;
import com.ing.tmrbank.pojo.SaveAccountResponse;
import com.ing.tmrbank.pojo.SaveFundTransferResponse;
import com.ing.tmrbank.pojo.UpdateAccountRequest;
import com.ing.tmrbank.service.FundTransferService;
import com.ing.tmrbank.service.FundTransferServiceImpl;
import com.ing.tmrbank.service.UserService;
import com.ing.tmrbank.service.UserServiceImp;
import com.ing.tmrbank.utils.UtilConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
//@ContextConfiguration(classes = UserTransactionHistoryApplication.class)
@ExcludeCategory({TransactionDao.class,UserDao.class,SwaggerConfig.class,
    UserTransactionHistoryApplication.class,SaveAccountRequest.class,
    SaveAccountResponse.class,UtilConstants.class,SaveFundTransferResponse.class,UpdateAccountRequest.class
    ,TransactionDao.class,UserDao.class,FundTransferService.class,UserService.class})

public class UserTransactionHistoryApplicationTests {
	
	@InjectMocks
	UserServiceImp service;
	
	@Mock
	UserDao repo;
	
	@Mock
	TransactionDao transRepo;
	@InjectMocks
	FundTransferServiceImpl fundService;
	
	
	
	//private WebMvc
	//@Test
	public void testSaveAccounts() {
		SaveAccountRequest request = new SaveAccountRequest();
		Account acc = new Account();
		//acc.s
		acc.setId(1);
		Mockito.when(repo.save(acc)).thenReturn(acc);
		 SaveAccountResponse response = service.saveAccount(request);
		//assertEquals(response.getStatus(), "Sucess");
		// asser
		 assertNotNull(response);
		
	}
	
	@Test
	 public void getFetchAccount() {
	  List<Account> accountList = new ArrayList<Account>();
	  //Account accOne = new Account();
	  Account accOne = new Account(1,"logesh","sekar","logesh","passwd","debited",10000.0,"logesh@xyz.com");
	  accountList.add(accOne);
	  Mockito.when(repo.findAll()).thenReturn(accountList);
	  List<Account> list = service.findAll();
	  assertThat(list).isEqualTo(accountList);
	 }
	
	@Test
	public void whenGettingTheUser() {
		Account account =new Account(1,"karthik","raja",1234565,"Raja","DPJk12","passwd","savings",10000.0,"nill","logesh","kk@gmail");
		
		Mockito.when(repo.findAccountById(1)).thenReturn(account);
		Account acc= service.getAccountById(account.getId());
		
		assertThat(account).isEqualTo(acc);
	}
	
	@Test
	public void whenGettingTransactions() {
		List<Transaction> transaction =new ArrayList<Transaction>();
		transaction.add(new Transaction(1,"logesh",2,1000.0,"debit","hdfc",1));
		Mockito.when(transRepo.findTransactionsById(1,"20","20")).thenReturn(transaction);
		
		List<Transaction> list =fundService.getTransactions(1,"20","20");
		
		assertThat(transaction.size()).isEqualTo(list.size());
		
	}
	
	
	@Test
	 public void getAccount() {
	  Account account = new Account();
	  account.setId(1);
	  account.setFirstName("logesh");
	  account.setLastName("sekar");
	  account.setUserName("logesh");
	  account.setPassword("passwd");
	  account.setAccountType("debited");
	  account.setBalance(10000.0);
	  account.setMobile((long) 1234567890);
	  account.setPan("ABCD");
	  account.setStatus("Created");
	  account.setUpdatedBy("Admin1");
	  account.setEmailId("logesh@xyz.com");
	  assertTrue(account.getId()==1);
	  assertTrue(account.getFirstName()=="logesh");
	  assertTrue(account.getLastName()=="sekar");
	  assertTrue(account.getUserName()=="logesh");
	  assertTrue(account.getPassword()=="passwd");
	  assertTrue(account.getAccountType()=="debited");
	  assertTrue(account.getBalance()==10000.0);
	  assertTrue(account.getMobile()==1234567890);
	  assertTrue(account.getPan()=="ABCD");
	  assertTrue(account.getStatus()=="Created");
	  assertTrue(account.getUpdatedBy()=="Admin1");
	  assertTrue(account.getEmailId()=="logesh@xyz.com");
	 }
	 
	 @Test
	 public void getTransaction() {
	  Transaction trans = new Transaction();
	  trans.setAccountNo(1);
	  trans.setAmount(1000);
	  trans.setBankName("abc");
	  trans.setBenName("karthik");
	  trans.setDate(new Date());
	  trans.setId(1);
	  trans.setTransactionType("Debit");
	  trans.setUserId(1);
	  Date date = new Date();
	  assertTrue(trans.getAccountNo()==1);
	  assertTrue(trans.getAmount()==1000);
	  assertTrue(trans.getBankName()=="abc");
	  assertTrue(trans.getBenName()=="karthik");
	  assertThat(trans.getDate()).isAfterOrEqualsTo(date);
	  assertTrue(trans.getId()==1);
	  assertTrue(trans.getTransactionType()=="Debit");
	  assertTrue(trans.getUserId()==1);


	 }	 

}
