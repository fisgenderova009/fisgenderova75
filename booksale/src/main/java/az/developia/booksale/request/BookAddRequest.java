package az.developia.booksale.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class BookAddRequest {
	private String name;
	private String author;
	private String description;
	private LocalDate publishedDate;
	private Double price;
}
