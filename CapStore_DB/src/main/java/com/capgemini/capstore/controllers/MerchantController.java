package com.capgemini.capstore.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToOne;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.beans.Image;
import com.capgemini.capstore.beans.Inventory;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.services.CapStoreAdminService;
import com.capgemini.capstore.services.CapStoreMerchantService;

@RestController
public class MerchantController {

	@Autowired
	public CapStoreMerchantService merchantService;
	@Autowired
	public CapStoreAdminService adminService;
	
	@RequestMapping(value = "/addproduct")
	public void addproduct(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		
			Product products=new Product();
			products.setProductName(jSon.getString("productName"));
			products.setProductDesc(jSon.getString("productDesc"));
			products.setProductSize(jSon.getInt("productSize"));
			products.setProductQuantity(jSon.getInt("productQuantity"));
			
			products.setProductPrice(jSon.getDouble("productPrice"));
			Image image=new Image();
			image.setImageUrl(jSon.getString("imageUrl"));
			products.setProductImage(image);
			products.setProductBrand(jSon.getString("productBrand"));
			products.setProductViews(jSon.getInt("productViews"));
			int merchantId=jSon.getInt("merchantId");
			Category category=new Category();
			category.setGroupCategoryId(jSon.getInt("groupCategoryId"));
			category.setCategoryName(jSon.getString("categoryName"));
			category.setCategoryDesc(jSon.getString("categoryDesc"));
			category.setProduct(products);
			products.setProductCategory(category);
			
			
			//products.setProductMerchant(productMerchant);
			
			long time = System.currentTimeMillis();
			java.sql.Date productAddDate = new java.sql.Date(time);
			products.setProductAddDate(productAddDate);
			merchantService.addProduct(products,merchantId);

	}
	
	@RequestMapping(value = "/addcategory")
	public void addcategory(@RequestBody  String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		Category category=new Category();
		category.setGroupCategoryId(jSon.getInt("groupCategoryId"));
		category.setCategoryName(jSon.getString("categoryName"));
		category.setCategoryDesc(jSon.getString("categoryDesc"));
		merchantService.addProductCategory(category);
	}
	
	
	
	@RequestMapping(value = "/removeproduct")
	public void removeproduct(int productId) {
		merchantService.removeProduct(productId);
	}
	
	@RequestMapping(value = "/removecategory")
	public void removecategory(int groupCategoryId) {
		merchantService.removeProductCategory(groupCategoryId);
	}
	
	
	@RequestMapping(value = "/displayInventory")
	public List<String> displayinventory(int merchantId) {
		List<Product> products=merchantService.displayInventory(merchantId);
		List<String> productName=new ArrayList<>();
		
		for (Product product : products) {
			productName.add(product.getProductName());
		}
		return productName;
		
	}
	
	@RequestMapping(value = "/updateProduct")
	public boolean updateProducts(int productId,int categoryId) {
		return merchantService.updateProductDetails(productId,categoryId);
		
	}
	
	@RequestMapping(value = "/checkMerchantOrder")
	public List<Integer> checkMerchantInventoryOrders(int merchantId) {
		
		List<OrderDetails> orders=merchantService.checkOrderDetails(merchantId);
List<Integer> orderId=new ArrayList<>();
		
		for (OrderDetails order : orders) {
			orderId.add(order.getOrderId());
		}
		return orderId;
		
	}
}
