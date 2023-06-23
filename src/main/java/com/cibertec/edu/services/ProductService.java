package com.cibertec.edu.services;

import java.io.InputStream;
import java.util.List;

import com.cibertec.edu.models.Product;

public interface ProductService {
		
	public List<Product>getAllProducts();
	public InputStream getReportProducts() throws Exception;
}
