package management.service;

import management.dto.BooksDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BookService {
    List<BooksDto> selectBookList();

    void insertBook(BooksDto booksDto, MultipartHttpServletRequest request);

    BooksDto selectBookDetail(Long bookId);

    void updateBook(BooksDto booksDto);

    void deleteBook(Long bookId);
}
