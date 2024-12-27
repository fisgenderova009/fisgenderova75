package az.developia.librarian_Fidan_Isgenderova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.librarian_Fidan_Isgenderova.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

}
