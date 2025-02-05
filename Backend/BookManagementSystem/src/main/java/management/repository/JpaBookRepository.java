package management.repository;

import management.entity.BookImagesEntity;
import management.entity.BooksEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaBookRepository extends CrudRepository<BooksEntity, Long> {
    // Query method
    List<BooksEntity> findAllByOrderByBookIdDesc();

    // Query annotation
    @Query("SELECT file FROM BookImagesEntity file WHERE file.book.bookId = :bookId AND file.imageId = :imageId")
    BookImagesEntity findBookImage(@Param("bookId") Long bookId, @Param("imageId") Long imageId);
}
