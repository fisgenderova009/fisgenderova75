package az.developia.booksale.response;

import java.util.List;

import org.springframework.validation.FieldError;

import lombok.Data;

@Data
public class ErrorResponse {
	private String message;
	private List<FieldError> validations;
}
