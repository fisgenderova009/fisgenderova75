package az.developia.librarian_Fidan_Isgenderova.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.librarian_Fidan_Isgenderova.entity.BookEntity;
import az.developia.librarian_Fidan_Isgenderova.entity.LibrarianEntity;
import az.developia.librarian_Fidan_Isgenderova.exception.MyException;
import az.developia.librarian_Fidan_Isgenderova.repository.BookRepository;
import az.developia.librarian_Fidan_Isgenderova.repository.LibrarianRepository;
import az.developia.librarian_Fidan_Isgenderova.request.BookAddRequest;
import az.developia.librarian_Fidan_Isgenderova.response.BookListResponse;
import az.developia.librarian_Fidan_Isgenderova.response.BookResponse;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private LibrarianRepository librarianRepository;
	@Autowired
	private LibrarianService librarianService;

	public BookResponse findById(Integer id) {
		BookResponse resp = new BookResponse();
		BookEntity book = repository.findById(id).orElseThrow(() -> new MyException("id not found", null));
		resp.setId(book.getId());
		resp.setName(book.getName());
		return resp;
	}

	public Integer add(BookAddRequest req) {
		BookEntity en = new BookEntity();
		mapper.map(req, en);
		en.setRegisterDate(LocalDateTime.now());
		en.setLibrarianId(librarianService.findIdByUsername());
		repository.save(en);
		return en.getId();

	}

	public void deleteById(Integer id) {
		repository.deleteById(id);

	}

	public BookListResponse findBooks(String query) {
		BookListResponse resp = new BookListResponse();
		List<BookEntity> books = repository.findBooks(librarianService.findIdByUsername(), query);
		List<BookResponse> dtos = new ArrayList<>();
		for (BookEntity en : books) {
			BookResponse r = new BookResponse();
			mapper.map(en, r);
			dtos.add(r);
		}
		resp.setBooks(dtos);
		return resp;
	}
}
