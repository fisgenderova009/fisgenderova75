package az.developia.booksale.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.booksale.repository.AuthorityRepository;

@Service
public class AuthorityService {
@Autowired
private AuthorityRepository repository;
public void addSellerAuthorities(String username) {
repository.addSellerAuthorities(username);
}
}