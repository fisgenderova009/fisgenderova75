package az.developia.booksale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="authority_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityListEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String authority;
private Integer seller;
private Integer customer;
}
