package az.developia.librarian_Fidan_Isgenderova.contoller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarian_Fidan_Isgenderova.exception.MyException;
import az.developia.librarian_Fidan_Isgenderova.request.BookAddRequest;

@RestController
public class BookController {
	
	
	@PostMapping(path="/books")
	@PreAuthorize(value="hasAuthority('ROLE_ADD_BOOK')")
	public String add(@RequestBody BookAddRequest req,BindingResult br) {
		if(br.hasErrors()) {
			throw new MyException("melumatin tamligi pozuldu",br);
		}
		System.out.println(req);
		return"Registered SuccessFully";
	}
}
