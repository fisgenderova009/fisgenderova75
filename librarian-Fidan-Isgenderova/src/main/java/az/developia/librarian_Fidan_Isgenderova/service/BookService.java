package az.developia.librarian_Fidan_Isgenderova.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarian_Fidan_Isgenderova.entity.BookEntity;
import az.developia.librarian_Fidan_Isgenderova.exception.MyException;
import az.developia.librarian_Fidan_Isgenderova.repository.BookRepository;
import az.developia.librarian_Fidan_Isgenderova.request.BookAddRequest;
import az.developia.librarian_Fidan_Isgenderova.response.BookResponse;

@Service
public class BookService {

@Autowired
private BookRepository repository;
@Autowired
private ModelMapper mapper;

public BookResponse findById(Integer id) {
	BookResponse resp=new BookResponse();
	BookEntity book=repository.findById(id).orElseThrow(()->new MyException("id not found",null));
	resp.setId(book.getId());
	resp.setName(book.getName());
	return resp;
}

public Integer add(BookAddRequest req) {
	BookEntity en=new BookEntity();
	mapper.map(req, en);
	repository.save(en);
	return en.getId();
	
}

public void deleteById(Integer id) {
	repository.deleteById(id);
	
}
}
