package az.developia.librarian_Fidan_Isgenderova.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarian_Fidan_Isgenderova.exception.MyException;
import az.developia.librarian_Fidan_Isgenderova.request.LibrarianAddRequest;
import az.developia.librarian_Fidan_Isgenderova.service.UserService;


@RestController
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping(path = "/librarian")
	public String addLibrarian(@RequestBody LibrarianAddRequest req,BindingResult br) {
		if(br.hasErrors()) {
			throw new MyException("nese oldu",br);
		}
		service.addLibrarian(req);

		System.out.println(req);
		return "successfully";
	}
}
