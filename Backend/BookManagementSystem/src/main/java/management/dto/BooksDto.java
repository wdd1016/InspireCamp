package management.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BooksDto {
    private Long bookId;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;

    @Pattern(regexp = "^[0-9]+$")
    private String isbn;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private BookImagesDto fileInfo;
}
