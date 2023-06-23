package com.cibertec.edu.models;

import java.util.List;
import java.util.ArrayList;
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
		public void setDescripcion(String descripcion) {
			this.descripcion =descripcion;
		}
		public List<Product>getProductsList(){
			return productosList;
		}
		
		public void setProductosList(List<Product>productosList) {
			this.productosList=productosList;
		}
		
		public String getFecha() {
			return descripcion;
		}
		public void setFecha(String fecha_registro) {
			this.fecha_registro = fecha_registro;
		}
}
