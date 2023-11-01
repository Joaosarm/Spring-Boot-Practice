package br.com.meli.springbootexercise.repositorys;

import br.com.meli.springbootexercise.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
