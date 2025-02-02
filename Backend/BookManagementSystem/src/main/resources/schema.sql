CREATE TABLE Books (
                       book_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 고유 식별자
                       title VARCHAR(255) NOT NULL,               -- 도서 제목
                       author VARCHAR(255) NOT NULL,              -- 저자
                       publisher VARCHAR(255),                    -- 출판사
                       published_date DATE,                       -- 출판일
                       isbn VARCHAR(20) UNIQUE,                   -- ISBN 번호
                       description TEXT,                          -- 도서 설명
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성 시각
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정 시각
                       deleted_yn CHAR(1) NOT NULL
);

CREATE TABLE BookImages (
                            image_id BIGINT AUTO_INCREMENT PRIMARY KEY,     -- 고유 식별자
                            book_id BIGINT NOT NULL,                        -- 도서와의 외래 키 관계
                            image_url VARCHAR(500) NOT NULL,                -- 이미지 URL
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성 시각
                            FOREIGN KEY (book_id) REFERENCES Books(book_id) ON DELETE CASCADE -- 도서 삭제 시 이미지도 삭제
);