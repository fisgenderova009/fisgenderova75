package az.developia.booksale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.booksale.Service.UserService;
import az.developia.booksale.exception.MyException;
import az.developia.booksale.request.SellerAddRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
private UserService service;


	@PostMapping(path = "/seller")
	public String addSeller( @Valid @RequestBody SellerAddRequest req,BindingResult br) {
		if(br.hasErrors()) {
			throw new MyException("nese var",br); 
		}
		service.addSeller(req );
		return "successfully";
		
	}
	
	
}
