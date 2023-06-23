package com.cibertec.edu.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.edu.models.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Long>{
		public List<Product> findAll();
}
