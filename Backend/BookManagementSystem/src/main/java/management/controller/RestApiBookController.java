package management.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import management.dto.BooksDto;
import management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestApiBookController {
    @Autowired
    private BookService bookService;

    // 목록 조회
    @Operation(summary = "책 목록 조회", description = "등록된 책 목록을 조회해서 반환합니다.")
    @GetMapping("/book")
    public List<BooksDto> openBookList() throws Exception {
        return bookService.selectBookList();
    }

    // 저장 처리
    @PostMapping(value = "/book", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> insertBook(@RequestParam("book") String bookData, MultipartHttpServletRequest request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        BooksDto booksDto = objectMapper.readValue(bookData, BooksDto.class);
        Map<String, String> result = new HashMap<>();
        try {
            bookService.insertBook(booksDto, request);
            result.put("message", "책 저장 성공");
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            result.put("message", "책 저장 실패");
            result.put("description", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    // 상세 조회
    @Operation(summary = "책 상세 조회", description = "책 아이디와 일치하는 게시물의 상세 정보를 조회해서 반환합니다.")
    @Parameter(name = "bookId", description = "책 아이디", required = true)
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Object> openBookDetail(@PathVariable("bookId") Long bookId) throws Exception {
        BooksDto booksDto = bookService.selectBookDetail(bookId);
        if (booksDto == null) {
            Map<String, Object> result = new HashMap<>();
            result.put("code", HttpStatus.NOT_FOUND.value());
            result.put("name", HttpStatus.NOT_FOUND.name());
            result.put("message", "게시판 번호 " + bookId + "와 일치하는 게시물이 존재하지 않습니다.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(booksDto);
        }
    }

    // 수정 처리
    @PutMapping("/book/{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId, @RequestBody BooksDto booksDto) throws Exception {
        booksDto.setBookId(bookId);
        bookService.updateBook(booksDto);
    }

    // 삭제 처리
    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) throws Exception {
        bookService.deleteBook(bookId);
    }
}
