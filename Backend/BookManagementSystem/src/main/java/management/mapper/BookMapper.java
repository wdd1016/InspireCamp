package management.mapper;

import management.dto.BookImagesDto;
import management.dto.BooksDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BooksDto> selectBookList();

    void insertBook(BooksDto booksDto);

    BooksDto selectBookDetail(@Param("bookId") Long bookId);

    void updateBook(BooksDto booksDto);

    void deleteBook(BooksDto booksDto);

    void insertBookFile(BookImagesDto bookImagesDto);

    BookImagesDto selectBookFile(Long bookId);
}
