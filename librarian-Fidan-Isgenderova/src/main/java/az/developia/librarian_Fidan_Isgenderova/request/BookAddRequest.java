package az.developia.librarian_Fidan_Isgenderova.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class BookAddRequest {
@NotNull(message="Ad mutleqdir")
@NotBlank(message="Adi bos qoymaq olmaz")
	private String name;
	private String author;
	private String description;
	@NotNull(message="nesr tarixi mutleqdir")
	@Past
	private LocalDate publishedDate;
	private Double price;
	
}
