`package az.developia.booksale.request;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import az.developia.booksale.annotation.EntityIdsiniYoxla;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Data
public class BookUpdateRequest {
	
	@NotNull
	@Positive
	@EntityIdsiniYoxla(message="bu id tapilmadi",value="books")
	private Integer id;
	@NotNull(message = "Ad mutleqdir")
	@NotBlank(message = "Adi bos qoymaq olmaz")
	private String name;

	private String author;

	private String description;

	@NotNull(message = "Nesr tarixi mutleqdir")
	@Past
	@JsonDeserialize(using=LocalDateDeserializer.class)
	private LocalDate publishedDate;

	private Double price;
}
