package az.developia.librarian_Fidan_Isgenderova.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarian_Fidan_Isgenderova.entity.LibrarianEntity;
import az.developia.librarian_Fidan_Isgenderova.repository.LibrarianRepository;
import az.developia.librarian_Fidan_Isgenderova.request.LibrarianAddRequest;

@Service
public class LibrarianService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private LibrarianRepository repository;
	public void add(LibrarianAddRequest req) {
		LibrarianEntity librarian=new LibrarianEntity();
		mapper.map(req, librarian);
		repository.save(librarian);
	}
	
}

