package com.ing.tmrbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.tmrbank.entity.Account;

@Repository
public interface UserDao extends JpaRepository<Account, Integer> {
	
	@Modifying
	@Query(value="update Account set Status=?2 where id=?1",nativeQuery=true)
	public void updateAccount(String userId, String status);
	
	Account findAccountById(int userId);


}
