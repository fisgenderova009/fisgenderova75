package az.developia.librarian_Fidan_Isgenderova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.librarian_Fidan_Isgenderova.entity.AuthorityEntity;
import jakarta.transaction.Transactional;
@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity,Integer>{

	
@Query(value="insert into authorities (username,authority) select ?1,authority from authority_list where librarian=1",nativeQuery=true)
@Modifying
	void addLibrarianAuthorities(String username);
}