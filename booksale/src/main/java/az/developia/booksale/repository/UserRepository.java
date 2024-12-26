package az.developia.booksale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.booksale.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String> {

}
