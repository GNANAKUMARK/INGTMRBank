package com.ing.tmrbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.tmrbank.entity.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction,Integer>{

	
	@Query(value = "select * from transaction where user_id=?1  and date between ?2 and ?3",nativeQuery = true)
	 List<Transaction> findTransactionsById(int id, String fromDate, String toDate);

}
