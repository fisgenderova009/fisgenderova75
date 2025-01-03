package az.developia.booksale.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
	private Integer id;
	private String name;
	private String author;
	private String description;
	private LocalDate publishedDate;
	private Double price;

}
