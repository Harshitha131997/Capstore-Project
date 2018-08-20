package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;

public interface CapStoreMerchantService {
	
	public List<OrderDetails> checkOrderDetails(int merchantId);
	
	public List<Product> displayInventory(int merchantId);
	
	public Product addProduct(Product product, int merchantId);
	
	public int removeProduct(int productId);
		
	public Category addProductCategory(Category category);
	
	public int removeProductCategory(int categoryId);
		
	public boolean updateProductDetails(int productId,int categoryId);

	
}
