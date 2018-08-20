package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;

public interface CapstoreOrdersDAO extends JpaRepository<OrderDetails, Integer>, CrudRepository<OrderDetails, Integer>{

	@Query("Select o from OrderDetails o Where o.product.productMerchant.merchantId = ?1")
	public List<OrderDetails> findOrdersByMerchantId(int merchantId);
}
