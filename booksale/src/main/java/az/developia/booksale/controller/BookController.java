package az.developia.booksale.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.booksale.model.Book;
import az.developia.booksale.request.BookAddRequest;

// /books?q=java
@RestController
public class BookController {
	@GetMapping(path = "/books")
	public List<Book> findBooks(@RequestParam(name = "query") String query) {
		System.out.println(query);
		List<Book>books= List.of(new Book(1, "Java", "Kimse", "This is Java", LocalDate.of(2024, 4, 12), 2.6),
				new Book(2, "CSS", "Kimse", "This is CSS", LocalDate.of(2024, 4, 12), 6.6));
		List<Book>filtered=books.stream().filter(b->b.getName().toLowerCase().contains(query)).collect(Collectors.toList());
		return filtered;

	}
@PostMapping(path="/add")
public String addBook(@RequestBody BookAddRequest req) {
		System.out.println(req);
		return "Registered successfully!";
	}
}
