package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Inventory;

public interface CapstoreInventoryDAO extends JpaRepository<Inventory,Integer>{

}
