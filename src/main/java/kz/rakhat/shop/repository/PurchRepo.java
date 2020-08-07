package kz.rakhat.shop.repository;

import kz.rakhat.shop.model.PurchasedProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchRepo extends JpaRepository<PurchasedProducts , Long> {
}
