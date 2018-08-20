package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.exceptions.CategoryDetailsNotFoundException;
import com.capgemini.capstore.exceptions.MerchantDetailsNotFoundException;
import com.capgemini.capstore.exceptions.OrderDetailsNotFoundException;
import com.capgemini.capstore.exceptions.ProductDetailsNotFoundException;
import com.capgemini.capstore.repo.CapstoreAdmin_MerchantDAO;
import com.capgemini.capstore.repo.CapstoreAdmin_ProductDAO;
import com.capgemini.capstore.repo.CapstoreCategoryDAO;

@Component(value="adminService")
public class CapStoreAdminServiceImpl implements CapStoreAdminService {
     @Autowired
     CapstoreAdmin_ProductDAO adminProductDAO;
     @Autowired
     CapstoreAdmin_MerchantDAO adminMerchantDAO;
     
     @Autowired         
     CapstoreCategoryDAO categoryDao;
	@Override
	public List<OrderDetails> checkAllOrders() {
		List<OrderDetails> orders=adminProductDAO.findAllOrders();
		if(orders.isEmpty())
			throw new OrderDetailsNotFoundException("No orders to display");
		return orders;
	}

//	@Override
//	public int removeItem(int productId) {
//		Product product = adminProductDAO.findProductByProductId(productId);
//		if(product == null)
//			throw new ProductDetailsNotFoundException("Product Id not found");
//		adminProductDAO.delete(product);
//		return productId;
//	}
//
//	@Override
//	public boolean permitMerchantToAdd() {
//		
//		return true;
//	}
//
//	@Override
//	public Category addItemCategory(Category category) {
//		return  categoryDao.save(category);
//	}
//
//	@Override
//	public int removeItemCategory(int categoryId) throws CategoryDetailsNotFoundException {
//		Category category = categoryDao.findByCategoryId(categoryId);
//		if(category == null)
//			throw new CategoryDetailsNotFoundException("Category Id not found");
//		categoryDao.delete(category);
//		return categoryId;
//		}


	@Override
	public Merchant addMerchant(Merchant merchant) {
		return adminMerchantDAO.save(merchant);
		 
	}

	@Override
	public int removeMerchant(int merchantId) {
		Merchant merchant = adminMerchantDAO.findMerchantByMerchantId(merchantId);
		if(merchant == null)
			throw new MerchantDetailsNotFoundException("Merchant Id not found");
		adminMerchantDAO.delete(merchant);
		return merchantId;
	}
	
	@Override
	public boolean updateMerchantDetails(Merchant merchant) {
		adminMerchantDAO.save(merchant);
		 return true;
	}

	@Override
	public List<Product> getAllInventory() {
		List<Product> listOfProducts = adminProductDAO.findAll();
		if(listOfProducts.isEmpty())
			throw new ProductDetailsNotFoundException("Inventory is Empty, Please add your products");
		return listOfProducts;
	}
}
