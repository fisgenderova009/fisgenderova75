package az.developia.librarian_Fidan_Isgenderova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.librarian_Fidan_Isgenderova.entity.LibrarianEntity;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity,Integer> {

	LibrarianEntity findByUsername(String username);

}
