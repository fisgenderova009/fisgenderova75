package az.developia.booksale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.booksale.entity.BookEntity;
import az.developia.booksale.response.BookResponse;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
@Query(value="select*from books where seller_id=?1 and name like%?2%",nativeQuery=true)
	List<BookResponse> findBooks(Integer sellerId,String query);

}
