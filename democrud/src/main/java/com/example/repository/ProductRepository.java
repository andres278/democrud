package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Product;

@Transactional
public interface ProductRepository extends CrudRepository<Product,Integer>{

}
