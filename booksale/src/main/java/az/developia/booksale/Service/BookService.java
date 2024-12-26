package az.developia.booksale.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.booksale.entity.BookEntity;
import az.developia.booksale.entity.SellerEntity;
import az.developia.booksale.exception.MyException;
import az.developia.booksale.repository.BookRepository;
import az.developia.booksale.repository.SellerRepository;
import az.developia.booksale.request.BookAddRequest;
import az.developia.booksale.response.BookListResponse;
import az.developia.booksale.response.BookResponse;
import jakarta.validation.Valid;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private SellerService sellerService;

	public BookResponse findById(Integer id) {
		BookResponse resp = new BookResponse();
		BookEntity book = repository.findById(id).orElseThrow(() -> new MyException("id not found", null));
		mapper.map(book,resp);
		return resp;

	}

	public Integer add( BookAddRequest req) {
		BookEntity en=new BookEntity();
		mapper.map(req,en);
		en.setRegisterDate(LocalDateTime.now());
		
		en.setSellerId(sellerService.findIdByUsername());
		repository.save(en);
		return en.getId();
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
		
	}

	public BookListResponse findBooks(String query) {
		BookListResponse resp=new BookListResponse();
		List<BookEntity> books = repository.findBooks(sellerService.findIdByUsername(), query);
		List <BookResponse> dtos=new ArrayList<BookResponse>();
		for(BookEntity en:books) {
			BookResponse r=new BookResponse();
			mapper.map(en,r);
			dtos.add(r);
		}
		resp.setBooks(dtos);
		return resp;
	}
	
}
