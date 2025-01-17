package com.example.demo.controller;

import com.example.demo.dto.SearchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class BookController {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes?";
    private final String SUBJECT_QUERY = "q=subject:";

    @PostMapping("/search")
    public ResponseEntity<String> searchBooksPost(@RequestBody SearchRequest requestBody) {
        // 조건에서 subject 추출
        String condition = requestBody.getCondition();

        // Google Books API URL 생성
        String url = GOOGLE_BOOKS_API_URL + SUBJECT_QUERY + condition;

        // API 호출, 응답 반환
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchBooksGet(@RequestParam String condition) {
        System.out.println(condition);
        // Google Books API URL 생성
        String url = GOOGLE_BOOKS_API_URL + SUBJECT_QUERY + condition;

        // API 호출, 응답 반환
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}

