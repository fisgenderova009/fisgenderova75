package az.developia.booksale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.booksale.entity.SellerEntity;

public interface SellerRepository extends JpaRepository<SellerEntity,Integer> {

	SellerEntity findByUsername(String username);

}
