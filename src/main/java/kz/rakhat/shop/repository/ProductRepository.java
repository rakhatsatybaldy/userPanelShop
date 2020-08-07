package kz.rakhat.shop.repository;

import kz.rakhat.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
    Product findByName(String  name);
}
