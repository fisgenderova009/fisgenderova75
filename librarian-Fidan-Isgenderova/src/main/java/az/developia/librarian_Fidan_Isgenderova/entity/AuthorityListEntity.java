package az.developia.librarian_Fidan_Isgenderova.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityListEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String authority;
private String librarian;
private String student;
}
