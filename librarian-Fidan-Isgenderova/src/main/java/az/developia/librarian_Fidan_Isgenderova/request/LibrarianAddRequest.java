package az.developia.librarian_Fidan_Isgenderova.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LibrarianAddRequest {

	private String name;
	private String surname;
	@NotNull
	private String username;
	@NotNull
	@Size(min=2,max=100)
	private String password;
	private String phone;
	private String email;
	private String address;

}
