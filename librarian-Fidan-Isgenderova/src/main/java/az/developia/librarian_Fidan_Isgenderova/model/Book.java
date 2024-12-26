package az.developia.librarian_Fidan_Isgenderova.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Book {
 
	private Integer id;
	private String name;
	private String author;
	private String description;
	private LocalDate publishedDate;
	private Double price;
}
