package az.developia.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.library.exception.MyException;
import az.developia.library.request.LibrarianAddRequest;
import az.developia.library.service.UserService;
import jakarta.validation.Valid;
@RequestMapping(path="/users")
@RestController
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping(path="/librarian")
public String addLibrarian( @ Valid @RequestBody LibrarianAddRequest req) {
	service.addLibrarian(req);
	return "Registered successfully";
	
}
}
