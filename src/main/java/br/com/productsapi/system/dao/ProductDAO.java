package br.com.productsapi.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.productsapi.system.models.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {

}
