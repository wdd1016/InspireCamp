package management.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookImagesDto {
    private Long imageId;
    private Long bookId;
    private String imageUrl;
    private LocalDateTime createdAt;
}
