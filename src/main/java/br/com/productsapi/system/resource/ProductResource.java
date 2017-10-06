package br.com.productsapi.system.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsapi.system.dao.ProductDAO;
import br.com.productsapi.system.models.Product;

@RestController
@RequestMapping("/api/products")
public class ProductResource {
	
	/**
	 * Injeção de depêndencia 
	 * Inserindo a Interface ProductDAO
	 */
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping
	public Collection<Product> listAll() {
		return productDAO.findAll();
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		if (product.getId() == null) {
			return productDAO.save(product);
		} else {
			return productDAO.save(product);
		}
	}
	
	@GetMapping(value="/{id}")
	public Product getProductWithId(@PathVariable Long id) {
		return productDAO.findOne(id);
	}
	
	@DeleteMapping(value="/{id}")
	public void  deleteProductWithId(@PathVariable Long id) {
		productDAO.delete(id);
	}
	
	@DeleteMapping
	public void deleteAllProducts() {
	    productDAO.deleteAll();
	}
	
}
