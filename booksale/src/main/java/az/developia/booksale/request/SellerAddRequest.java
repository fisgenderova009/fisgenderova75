package az.developia.booksale.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SellerAddRequest {
	private String name;
	private String surname;
	private String username;
	private String password;
	private String phone;
	private LocalDate registerDate;
	private String adress;
}
