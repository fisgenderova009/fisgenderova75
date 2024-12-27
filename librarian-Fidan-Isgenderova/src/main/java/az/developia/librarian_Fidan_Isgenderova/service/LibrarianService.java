package az.developia.librarian_Fidan_Isgenderova.service;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.librarian_Fidan_Isgenderova.entity.LibrarianEntity;
import az.developia.librarian_Fidan_Isgenderova.repository.LibrarianRepository;
import az.developia.librarian_Fidan_Isgenderova.request.LibrarianAddRequest;

@Service
public class LibrarianService {
	

	@Autowired
	private LibrarianRepository repository;	
	public void add(LibrarianAddRequest req) {
		LibrarianEntity librarian=new LibrarianEntity();
		librarian.setAddress(req.getAddress());
		librarian.setEmail(req.getEmail());
		librarian.setName(req.getName());
		librarian.setPhone(req.getPhone());
		librarian.setSurname(req.getSurname());
		librarian.setUsername(req.getUsername());
		librarian.setRegisterDate(LocalDateTime.now());
		repository.save(librarian);
	}
	public Integer findIdByUsername() {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		LibrarianEntity librarian=repository.findByUsername(username);
		Integer id=librarian.getId();
		return id;
	}
}
