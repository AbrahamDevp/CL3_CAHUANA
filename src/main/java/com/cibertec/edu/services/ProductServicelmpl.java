package com.cibertec.edu.services;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.models.Product;
import com.cibertec.edu.repositories.ProductDao;

@Service
public class ProductServicelmpl implements ProductService {
	
	@Autowired
		private ProductDao productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) this.productRepository.findAll();
	}

	@Override
	public InputStream getReportProducts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}





}
