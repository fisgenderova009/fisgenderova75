package az.developia.booksale.response;

import java.util.List;

import lombok.Data;
@Data
public class BookListResponse {
private List<BookResponse> books;
}
