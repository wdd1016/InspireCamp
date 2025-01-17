package com.example.demo.controller;

import com.example.demo.dto.SearchRequest;
import com.example.demo.entity.TestSpring;
import com.example.demo.repository.TestSpringRepository;
import com.example.demo.service.TestSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private TestSpringRepository testSpringRepository;

    private final TestSpringService testSpringService;

    @Autowired
    public BookController(TestSpringService testSpringService) {
        this.testSpringService = testSpringService;
    }

    @PostMapping("/search")
    public ResponseEntity<String> searchBooksPost(@RequestBody SearchRequest requestBody) {
        // 조건에서 subject 추출
        String condition = requestBody.getCondition();

        // Google Books API URL 생성
        String url = "https://www.googleapis.com/books/v1/volumes?q=subject:" + condition;

        // API 호출, 응답 반환
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchBooksGet(@RequestParam String condition) {
        // Google Books API URL 생성
        String url = "https://www.googleapis.com/books/v1/volumes?q=subject:" + condition;

        // API 호출, 응답 반환
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    // Get 요청 : TestSpring에 데이터 추가
    @GetMapping("/add")
    public ResponseEntity<String> addTestSpringData() {
        // TestSpring 엔티티 생성
        TestSpring newEntity = new TestSpring();
        newEntity.setName("Sample Name");
        newEntity.setDescription("This is a sample description");

        // 데이터베이스에 저장
        testSpringRepository.save(newEntity);

        // 결과 반환
        return ResponseEntity.ok("TestSpring 데이터가 추가되었습니다!");
    }

    // Get 요청 : TestSpring 데이터 추가
    // 가장 많이 쓰이는 패턴
    @GetMapping("/addMVC")
    public ResponseEntity<String> addTestMVCSpringData() {
        // 서비스 호출로 데이터 추가
        testSpringService.addTestSpring("Sample MVC Name", "This is a sample MVC description");
        return ResponseEntity.ok("TestSpring MVC 데이터가 추가되었습니다!");
    }
}
