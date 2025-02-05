package management.service;

import management.entity.BooksEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface JpaBookService {
    List<BooksEntity> selectBookList();

    void insertBook(BooksEntity booksEntity, MultipartHttpServletRequest request);

    BooksEntity selectBookDetail(Long bookId);

    void updateBook(BooksEntity booksEntity);

    void deleteBook(Long bookId);
}
