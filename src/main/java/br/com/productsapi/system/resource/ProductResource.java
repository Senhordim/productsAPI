package br.com.productsapi.system.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/**
	 * Declrando requisição GET  
	 * Retornando todos produtos
	 */
	@GetMapping
	public Collection<Product> listAll() {
		return productDAO.findAll();
	}
	
	/**
	 * Declrando requisição POST  
	 * Para inserir um produto
	 */
	@PostMapping("/api/product")
	public Product save(@RequestBody Product product) {
		productDAO.save(product);
		return product;
	}
	

	
	/**
	 * Declrando requisição GET  
	 * Retorna produto por id
	 */
	@GetMapping(value="/{id}")
	public Product getProductWithId(@PathVariable Long id) {
		return productDAO.findOne(id);
	}
	
	
	

}
