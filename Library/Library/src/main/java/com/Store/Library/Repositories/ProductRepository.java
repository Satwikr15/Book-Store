package com.Store.Library.Repositories;


import com.Store.Library.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
