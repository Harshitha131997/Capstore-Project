package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.Category;

public interface CapstoreCategoryDAO extends JpaRepository<Category, Integer>{

	@Query("SELECT c FROM Category c WHERE c.groupCategoryId = ?1")
	public Category findBygroupCategoryId(int groupCategoryId);
	
	
}
