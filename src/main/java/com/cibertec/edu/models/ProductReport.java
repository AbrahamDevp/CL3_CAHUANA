package com.cibertec.edu.models;

import java.util.List;

public class ProductReport {

		private List<Product>productosList;
		private String descripcion;
		private String fecha_registro;
		
		
		public ProductReport() {
			super();
			this.productosList= new ArrayList<>();
			
		}
		
		public String getDescripcion() {
			return descripcion;
		}
		public String getFecha() {
			return fecha_registro;
		}
		public List<Product>getProductsList(){
			return productosList;
		}
		
		public void setProductosList(List<Product>productosList) {
			this.productosList=productosList;
		}
		
		public String getDescripcion1() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion=descripcion;
		}
}
