package az.developia.library.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.library.entity.UserEntity;
import az.developia.library.repository.UserRepository;
import az.developia.library.request.LibrarianAddRequest;

@Service
public class UserService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
private UserRepository repository;

public void addLibrarian(LibrarianAddRequest req) {
	UserEntity user=new UserEntity();
	mapper.map(req,user);
	repository.save(user);
	}
}
