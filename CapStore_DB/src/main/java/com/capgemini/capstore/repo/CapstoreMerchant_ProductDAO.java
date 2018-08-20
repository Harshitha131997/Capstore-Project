package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;

public interface CapstoreMerchant_ProductDAO extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer>{

}
