package com.example.demo.controller;

import com.example.demo.dto.SearchRequest;
import com.example.demo.entity.TestSpring;
import com.example.demo.repository.TestSpringRepository;
import com.example.demo.service.TestSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


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

    // Get 요청 : 모든 데이터 조회
    @GetMapping("/items")
    public ResponseEntity<List<TestSpring>> getItems() {
        List<TestSpring> testSpringList = testSpringRepository.findAll();
        return ResponseEntity.ok(testSpringList);
    }

    // Get 요청 : 단일 데이터 조회 (id)
    @GetMapping("/item/{id}")
    public ResponseEntity<TestSpring> getItem(@PathVariable Long id) {
        return testSpringRepository.findById(id)
                .map(ResponseEntity::ok)      // 값이 있으면 OK(200)와 엔티티 반환
                .orElse(ResponseEntity.notFound().build()); // 없으면 404
    }

    // Put 요청 : 특정 데이터 수정 (id)
    @PutMapping("/update/{id}")
    public ResponseEntity<TestSpring> updateTestSpring(@PathVariable Long id, @RequestBody TestSpring updatedTestSpring) {
        // 1. id로 기존 데이터 조회
        return testSpringRepository.findById(id)
                .map(existingData -> {
                    // 2. 기존 데이터에 새로운 값 세팅
                    existingData.setName(updatedTestSpring.getName());
                    existingData.setDescription(updatedTestSpring.getDescription());

                    // 3. 다시 저장
                    TestSpring savedData = testSpringRepository.save(existingData);
                    return ResponseEntity.ok(savedData);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete 요청
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTestSpring(@PathVariable Long id) {
        return testSpringRepository.findById(id)
                .map(existingData -> {
                    testSpringRepository.delete(existingData);
                    return ResponseEntity.ok("삭제 성공! ID = " + id);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
