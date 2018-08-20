package com.capgemini.capstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Inventory;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.CapStoreAdminService;

@RestController
public class AdminController {

	@Autowired
	public CapStoreAdminService adminService;
	
	@RequestMapping(value="/addmerchant")
	public void addMerchant(@RequestBody Merchant merchant)
	{
		String mobileNo=merchant.getMobileNo();
		String merchantName=merchant.getMerchantName();
		Address merchantAddress=merchant.getMerchantAddress();
		String merchantEmail=merchant.getMerchantEmail();
		Merchant merchants= new Merchant();
		merchants.setMobileNo(mobileNo);
		merchants.setMerchantName(merchantName);
		merchants.setMerchantAddress(merchantAddress);
		merchants.setMerchantEmail(merchantEmail);
		Inventory merchantInventory=new Inventory();
		merchants.setMerchantInventory(merchantInventory);
		merchants.setMerchantRevPercent(20);
		long time = System.currentTimeMillis();
		java.sql.Date dateOfReg = new java.sql.Date(time);
		merchants.setDateOfReg(dateOfReg);
		adminService.addMerchant(merchants);
		
	}
	

	@RequestMapping(value = "/removemerchant")
	public void removemerchant(int merchantId) {
		adminService.removeMerchant(merchantId);
	}
	
	@RequestMapping(value = "/displayallInventory")
	public List<String> displayAllInventories() {
		List<Product> products=adminService.getAllInventory();
		List<String> productName=new ArrayList<>();
		
		for (Product product : products) {
			productName.add(product.getProductName());
		}
		return productName;
		
	}
}
