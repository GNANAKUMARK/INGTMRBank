package com.ing.tmrbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.tmrbank.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

}
