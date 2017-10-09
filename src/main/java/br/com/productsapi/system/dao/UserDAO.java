package br.com.productsapi.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.productsapi.system.models.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
