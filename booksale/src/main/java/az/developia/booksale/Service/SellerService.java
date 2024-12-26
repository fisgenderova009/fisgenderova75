package az.developia.booksale.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.booksale.entity.SellerEntity;
import az.developia.booksale.repository.SellerRepository;
import az.developia.booksale.request.SellerAddRequest;

@Service
public class SellerService {
@Autowired
private SellerRepository repository;
public void add(SellerAddRequest req) {
	SellerEntity seller=new SellerEntity();
	seller.setAddress(req.getAdress());
	seller.setEmail(req.getEmail());
	seller.setName(req.getName());
	seller.setPhone(req.getPhone());
	seller.setRegisterDate(req.getRegisterDate());
	seller.setSurname(req.getSurname());
	seller.setUsername(req.getUsername());
	repository.save(seller);
}
public Integer findIdByUsername() {
	String username=SecurityContextHolder.getContext().getAuthentication().getName();
	SellerEntity seller=repository.findByUsername(username);
	Integer id=seller.getId();
	return id;
}
}
