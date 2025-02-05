package management.service;

import lombok.extern.slf4j.Slf4j;
import management.common.FileUtils;
import management.entity.BookImagesEntity;
import management.entity.BooksEntity;
import management.repository.JpaBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// @Transactional
@Slf4j
@Service
public class JpaBookServiceImpl implements JpaBookService {
    @Autowired
    private JpaBookRepository jpaBookRepository;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public List<BooksEntity> selectBookList() {

        return jpaBookRepository.findAllByOrderByBookIdDesc();
    }

    @Override
    public void insertBook(BooksEntity booksEntity, MultipartHttpServletRequest request) {
        booksEntity.setCreatedAt(LocalDateTime.now());
        booksEntity.setUpdatedAt(LocalDateTime.now());
        try {
            BookImagesEntity fileInfo = fileUtils.parseFileInfo(request);
            if (fileInfo != null && fileInfo.getImageUrl() != null) {
                // 타임스탬프 값 설정 (파일 정보 엔티티에도 값을 할당)
                fileInfo.setCreatedAt(LocalDateTime.now());

                // 양방향 연관관계 설정
                booksEntity.setFileInfo(fileInfo);
                fileInfo.setBook(booksEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jpaBookRepository.save(booksEntity);
    }

    @Override
    public BooksEntity selectBookDetail(Long bookId) {
        Optional<BooksEntity> optional = jpaBookRepository.findById(bookId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public void updateBook(BooksEntity booksEntity) {
        BooksEntity existingBook = jpaBookRepository.findById(booksEntity.getBookId()).orElse(null);
        if (existingBook != null) {
            existingBook.setUpdatedAt(LocalDateTime.now());
            existingBook.setDescription(booksEntity.getDescription());
            jpaBookRepository.save(existingBook);
        }
    }

    @Override
    public void deleteBook(Long bookId) {
        jpaBookRepository.deleteById(bookId);
    }
}
