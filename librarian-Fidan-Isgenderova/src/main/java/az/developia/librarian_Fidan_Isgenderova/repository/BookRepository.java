package az.developia.librarian_Fidan_Isgenderova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.librarian_Fidan_Isgenderova.entity.BookEntity;
import az.developia.librarian_Fidan_Isgenderova.response.BookResponse;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
@Query(value="select*from books where seller_id=?1 and name like %?2%",nativeQuery=true)
	List<BookEntity> findBooks(Integer sellerId,String query);

}
