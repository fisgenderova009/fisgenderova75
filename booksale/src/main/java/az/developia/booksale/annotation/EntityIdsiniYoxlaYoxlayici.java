package az.developia.booksale.annotation;

import az.developia.booksale.repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EntityIdsiniYoxlaYoxlayici implements ConstraintValidator<EntityIdsiniYoxla,Integer> {
private String tableName;
private BookRepository bookRepository;
@Override
public void initialize(EntityIdsiniYoxla a) {
	this.tableName=a.value();
}
	@Override
	public boolean isValid(Integer id, ConstraintValidatorContext context) {
		Boolean present=bookRepository.findById(id).isPresent();
		if(present) {
			return true;
		}
		return false;
	}

}
