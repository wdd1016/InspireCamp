package management.service;

import lombok.extern.slf4j.Slf4j;
import management.common.FileUtils;
import management.dto.BookImagesDto;
import management.dto.BooksDto;
import management.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.time.LocalDateTime;
import java.util.List;

// @Transactional
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public List<BooksDto> selectBookList() {
        return bookMapper.selectBookList();
    }

    @Override
    public void insertBook(BooksDto booksDto, MultipartHttpServletRequest request) {
        booksDto.setCreatedAt(LocalDateTime.now());
        booksDto.setUpdatedAt(LocalDateTime.now());

        bookMapper.insertBook(booksDto);
        try {
            BookImagesDto fileInfo = fileUtils.parseFileInfo(booksDto.getBookId(), request);

            if (fileInfo != null && fileInfo.getBookId() != null) {
                fileInfo.setCreatedAt(LocalDateTime.now());
                bookMapper.insertBookFile(fileInfo);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public BooksDto selectBookDetail(Long bookId) {
        BooksDto booksDto = bookMapper.selectBookDetail(bookId);
        if (booksDto != null) {
            BookImagesDto bookFileInfo = bookMapper.selectBookFile(bookId);
            booksDto.setFileInfo(bookFileInfo);
        }
        return booksDto;
    }

    @Override
    public void updateBook(BooksDto booksDto) {
        booksDto.setUpdatedAt(LocalDateTime.now());
        bookMapper.updateBook(booksDto);
    }

    @Override
    public void deleteBook(Long bookId) {
        BooksDto booksDto = new BooksDto();
        booksDto.setBookId(bookId);
        bookMapper.deleteBook(booksDto);
    }
}
