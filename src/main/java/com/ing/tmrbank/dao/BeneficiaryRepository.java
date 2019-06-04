package com.ing.tmrbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.tmrbank.entity.Beneficiary;
import com.ing.tmrbank.pojo.BeneficiaryDetails;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
	@Query("SELECT new com.ing.tmrbank.pojo.BeneficiaryDetails(t.name, t.accNO, t.mobile, t.bankName, t.ifscCode, t.status)"
			+ " FROM Beneficiary t WHERE t.userId = :userId")
	List<BeneficiaryDetails> getAllBeneficiaries(@Param("userId") Long userId);
}
