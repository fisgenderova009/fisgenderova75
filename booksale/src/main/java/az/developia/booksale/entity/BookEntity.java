package az.developia.booksale.entity;

import java.time.LocalDate;
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
@Entity
@Table(name="books")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String name;
private Double price;
private LocalDate publishDate;
private LocalDateTime registerDate;
private Integer quantity;
private Integer sellerId;
}
