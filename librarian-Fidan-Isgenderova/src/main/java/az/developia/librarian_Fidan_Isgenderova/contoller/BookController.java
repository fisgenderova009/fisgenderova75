package az.developia.librarian_Fidan_Isgenderova.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarian_Fidan_Isgenderova.exception.MyException;
import az.developia.librarian_Fidan_Isgenderova.request.BookAddRequest;
import az.developia.librarian_Fidan_Isgenderova.response.BookResponse;
import az.developia.librarian_Fidan_Isgenderova.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;

	@PostMapping(path = "/books")
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public ResponseEntity<Integer> add(@RequestBody BookAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException("melumatin tamligi pozuldu", br);
		}
		Integer id = service.add(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
//		return new ResponseEntity<Integer>(id,HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public BookResponse findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")
	public void deleteById(Integer id) {
		service.deleteById(id);
	}
}
