package az.developia.booksale.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class BookAddRequest {
	@NotNull(message = "Ad mutleqdir")
	@NotBlank(message = "Adi bos qoymaq olmaz")
	private String name;

	private String author;

	private String description;

	@NotNull(message = "Nesr tarixi mutleqdir")
	@Past
	private LocalDate publishedDate;

	private Double price;
}
