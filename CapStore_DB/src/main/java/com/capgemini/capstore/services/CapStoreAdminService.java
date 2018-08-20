package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;

public interface CapStoreAdminService {
	public List<OrderDetails> checkAllOrders();
	public List<Product> getAllInventory();

//	public int removeItem(int productId);
//     
//	public boolean permitMerchantToAdd();
//	
//	public Category addItemCategory(Category category);
//	
//	public int removeItemCategory(int categoryId) throws CategoryDetailsNotFoundException;
		
	public Merchant addMerchant(Merchant merchant);
	
	public boolean updateMerchantDetails(Merchant merchant);
	
	public int removeMerchant(int merchantId);
	


}
