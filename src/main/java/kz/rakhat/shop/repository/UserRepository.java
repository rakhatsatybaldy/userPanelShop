package kz.rakhat.shop.repository;

import kz.rakhat.shop.model.Product;
import kz.rakhat.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
    User findByEmail(String email);

}
