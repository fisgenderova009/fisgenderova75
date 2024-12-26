package az.developia.booksale.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import az.developia.booksale.entity.UserEntity;
import az.developia.booksale.repository.UserRepository;
import az.developia.booksale.request.SellerAddRequest;

@Service
public class UserService {
	@Autowired
private UserRepository repository;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private SellerService sellerService;
	
	public void addSeller(SellerAddRequest req) {
		UserEntity user=new UserEntity();
		user.setUsername(req.getUsername());
		user.setPassword("{noop}"+req.getPassword());
		user.setEnabled(1);
		repository.save(user);
		authorityService.addSellerAuthorities(req.getUsername());
		sellerService.add(req);
	}
}
