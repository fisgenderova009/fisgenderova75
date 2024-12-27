package az.developia.librarian_Fidan_Isgenderova.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "librarians")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String email;
	private String username;
	private LocalDateTime registerDate;
}

