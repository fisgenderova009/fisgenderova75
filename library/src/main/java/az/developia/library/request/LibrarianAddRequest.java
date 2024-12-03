package az.developia.library.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LibrarianAddRequest {
	@NotNull(message = "Ad mutleqdir")
	@NotBlank(message = "Adi bos qoymaq olmaz")
	private String name;
	@NotNull(message = "Username mutleqdir")
	private String username;
	@Size(min = 2, max = 100)
	private String password;
	private String phone;
	private String address;
	private String email;
}
