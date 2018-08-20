package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.Inventory;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.CapstoreCategoryDAO;
import com.capgemini.capstore.repo.CapstoreInventoryDAO;
import com.capgemini.capstore.repo.CapstoreMerchantDAO;
import com.capgemini.capstore.repo.CapstoreMerchant_ProductDAO;
import com.capgemini.capstore.repo.CapstoreOrdersDAO;

@Component(value="merchantService")
public class CapStoreMerchantServiceImpl implements CapStoreMerchantService {

	@Autowired
	public CapstoreMerchant_ProductDAO productDao;
	CapStoreAdminService adminservice;

	@Autowired
	public CapstoreMerchantDAO merchantDao;
	
	@Autowired
	public CapstoreOrdersDAO orderDao;
	
	@Autowired
	public CapstoreInventoryDAO inventoryDao;
	
	
	@Autowired
	public CapstoreCategoryDAO categoryDao;

	@Override
	public List<OrderDetails> checkOrderDetails(int merchantId) {
		List<OrderDetails> listOfOrderDetails = orderDao.findOrdersByMerchantId(merchantId);
		return listOfOrderDetails;
	}

	@Override
	public Product addProduct(Product product,int merchantId) {
		List <Product> products = new ArrayList<Product>();
		Merchant merchantProduct=merchantDao.getOne(merchantId);
		int inventoryId=merchantProduct.getMerchantInventory().getInventoryId();
		product.setProductMerchant(merchantProduct);
		products.add(product);
		Inventory inventory=inventoryDao.getOne(inventoryId);
		inventory.setProducts(products);
		inventoryDao.save(inventory);
		 //productDao.save(product);
		 return product;
	}

	@Override
	public int removeProduct(int productId) {
		Product product = productDao.getOne(productId);
		Merchant merchantProduct=product.getProductMerchant();
		int inventoryId=merchantProduct.getMerchantInventory().getInventoryId();
		Inventory inventory=inventoryDao.getOne(inventoryId);
		List <Product> inventoryProducts=inventory.getProducts();
		inventoryProducts.remove(product);
		int categoryId=product.getProductCategory().getCategoryId();
		Category category=categoryDao.getOne(categoryId);
		categoryDao.delete(category);
		//int merchantId = merchantProduct.getMerchantId();
	
		//merchantDao.delete(merchantProduct);
		
		//	productDao.delete(product);
		return productId;
	}

	@Override
	public List<Product> displayInventory(int merchantId) {
		List<Product> listOfProducts = merchantDao.findByMerchantId(merchantId);
		return listOfProducts;
	}

	@Override
	public Category addProductCategory(Category category) {
			return categoryDao.save(category);

	}

	@Override
	public int removeProductCategory(int groupcategoryId) {
//		Category category = categoryDao.findBygroupCategoryId(groupcategoryId);
//		Product product = category.getProduc
//		products.removeAll(products);
		//categoryDao.delete(category);
		return groupcategoryId;
	}



	@Override
	public boolean updateProductDetails(int productId, int categoryId) {
		Product product = productDao.getOne(productId);
		Category category=categoryDao.getOne(categoryId);
System.out.println(category);
		product.setProductCategory(category);
		product.setProductViews(4);
		System.out.println(product);
		productDao.save(product);

		return true;
	}


}
