package az.developia.librarian_Fidan_Isgenderova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarian_Fidan_Isgenderova.entity.UserEntity;
import az.developia.librarian_Fidan_Isgenderova.repository.UserRepository;
import az.developia.librarian_Fidan_Isgenderova.request.LibrarianAddRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private LibrarianService librarianService;
	
	public void addLibrarian(LibrarianAddRequest req) {
		UserEntity user=new UserEntity();
		user.setUsername(req.getUsername());
		user.setPassword("{noop}"+req.getPassword());
		user.setEnabled(1);
		repository.save(user);
		authorityService.addLibrarianAuthorities(req.getUsername());
		librarianService.add(req);
	}
	
}
