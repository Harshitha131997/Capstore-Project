package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;

public interface CapstoreAdmin_ProductDAO extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer>{

	@Query("Select o from OrderDetails o")
	public List<OrderDetails> findAllOrders();
	
	@Query("Select p from Product p Where p.productId = ?1")
	public Product findProductByProductId(int productId);
	
	@Query("Select o from OrderDetails o Where o.orderId = ?1")
	public OrderDetails getOrderByOrderId(int orderId);
}
