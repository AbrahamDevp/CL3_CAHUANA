package com.cibertec.edu.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.models.Product;
import com.cibertec.edu.models.ProductReport;
import com.cibertec.edu.repositories.ProductDao;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
		try {
			List<Product> listaProducto = this.getAllProducts();
			List<ProductReport> listData = new ArrayList<ProductReport>();
			listData.add(new ProductReport());
			listData.get(0).setProductosList(listaProducto);
			listData.get(0).setDescripcion("Verdesito Platano");
			listData.get(0).setFecha("23-06-23");
			JRBeanCollectionDataSource dts = new JRBeanCollectionDataSource(listData);
			// PARAMETROS
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("IMAGE_PATH",
					"https://www.logolynx.com/images/logolynx/2d/2d0872912b6970a81b093aaf1bd027c7.jpeg");
			// GENERACION DEL REPORTE
			JasperReport jasperReportObj = getJasperReportCompiled();
			JasperPrint jPrint = JasperFillManager.fillReport(jasperReportObj, parameters, dts);
			InputStream result = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(jPrint));
			return result;
		} catch (JRException ex) {
			throw ex;
		}

	}

	private JasperReport getJasperReportCompiled() {
		try {
			InputStream studentReportStream = getClass().getResourceAsStream("/jasper/products_report.jrxml");
			JasperReport jasper = JasperCompileManager.compileReport(studentReportStream);
			return jasper;
		} catch (Exception e) {
			return null;
		}
	}

}
