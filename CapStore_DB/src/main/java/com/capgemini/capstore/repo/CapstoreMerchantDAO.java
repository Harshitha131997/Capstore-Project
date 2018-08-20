package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Inventory;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;

public interface CapstoreMerchantDAO extends JpaRepository<Merchant, Integer>, CrudRepository<Merchant, Integer>{
	@Query("Select m.merchantInventory.products from Merchant m Where m.merchantId = ?1")
	public List<Product> findByMerchantId(int merchantId);
}
