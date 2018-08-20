package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Merchant;


public interface CapstoreAdmin_MerchantDAO extends JpaRepository<Merchant, Integer>, CrudRepository<Merchant, Integer>{

	@Query("Select m from Merchant m Where m.merchantId = ?1")
	public Merchant findMerchantByMerchantId(int merchantId);
}
