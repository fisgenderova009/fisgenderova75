package az.developia.librarian_Fidan_Isgenderova.handlers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.librarian_Fidan_Isgenderova.exception.MyException;
import az.developia.librarian_Fidan_Isgenderova.response.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlers {
@ExceptionHandler
	public ErrorResponse handleMyException(MyException exc) {
		ErrorResponse resp=new ErrorResponse();
		resp.setMessage(exc.getMessage());
		resp.setValidations(exc.getBr().getFieldErrors());
		return resp;
	}

}
