package az.developia.librarian_Fidan_Isgenderova.exception;

import org.springframework.validation.BindingResult;

import lombok.Data;
@Data
public class MyException extends RuntimeException {
private BindingResult br;
	
	public MyException(String message,BindingResult br) {
		super(message);
		this.br=br;
	}
}
