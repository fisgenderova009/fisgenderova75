package az.developia.booksale.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SellerAddRequest {
	private String name;
	private String surname;
	@NotNull
	private String username;
	@NotNull
	@Size(min=2,max=100)
	private String password;
	private String phone;
	private String adress;
	private String email;
	private LocalDateTime registerDate;
}
