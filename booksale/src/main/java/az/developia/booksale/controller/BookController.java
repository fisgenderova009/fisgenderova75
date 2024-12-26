package az.developia.booksale.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.booksale.Service.BookService;
import az.developia.booksale.exception.MyException;
import az.developia.booksale.model.Book;
import az.developia.booksale.request.BookAddRequest;
import az.developia.booksale.request.BookUpdateRequest;
import az.developia.booksale.response.BookListResponse;
import az.developia.booksale.response.BookResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/books")
public class BookController {
	@Autowired
	private BookService service;

	// /books?q=java
	@GetMapping
	@PreAuthorize(value = "hasAuthorize('ROLE_GET_BOOKS_FOR_SELLER')")
	public BookListResponse findBooks(@RequestParam(name = "query", required = false, defaultValue = "java") String query) {
		return service.findBooks(query);

	}

	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public ResponseEntity<Integer> addBook(@Valid @RequestBody BookAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException("melumatlarin tamilig pozuldu", br);
		}
		service.add(req);
		Integer id = service.add(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
//		return new ResponseEntity<Integer>(id,HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}") // /books/44
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
	public BookResponse findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@DeleteMapping(path = "/{id}") // /books/44
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
	@PutMapping
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")
	public ResponseEntity<Void> updateBook(@Valid @RequestBody BookUpdateRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException("melumatlarin tamilig pozuldu", br);
		}
	return null;
	}
}
