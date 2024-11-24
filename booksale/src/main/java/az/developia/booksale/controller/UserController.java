package az.developia.booksale.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.booksale.request.SellerAddRequest;

@RestController
public class UserController {

	@PostMapping(path = "/sellers")
	public void addSeller(@RequestBody SellerAddRequest req) {
		System.out.println(req);
	}
}
