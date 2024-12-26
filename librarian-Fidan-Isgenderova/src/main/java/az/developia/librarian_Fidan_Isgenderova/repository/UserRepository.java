package az.developia.librarian_Fidan_Isgenderova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.librarian_Fidan_Isgenderova.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String> {

}
