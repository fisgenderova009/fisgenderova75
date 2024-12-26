package az.developia.librarian_Fidan_Isgenderova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarian_Fidan_Isgenderova.repository.AuthorityRepository;



@Service
public class AuthorityService {
	@Autowired
private AuthorityRepository repository;

	public void addLibrarianAuthorities(String username) {
		repository.addLibrarianAuthorities(username);
		
	}

}
