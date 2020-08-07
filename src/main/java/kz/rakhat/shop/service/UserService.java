package kz.rakhat.shop.service;

import kz.rakhat.shop.model.User;
import kz.rakhat.shop.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}
