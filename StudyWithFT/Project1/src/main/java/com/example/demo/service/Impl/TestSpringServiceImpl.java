package com.example.demo.service.Impl;

import com.example.demo.entity.TestSpring;
import com.example.demo.repository.TestSpringRepository;
import com.example.demo.service.TestSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSpringServiceImpl implements TestSpringService {

    private final TestSpringRepository testSpringRepository;

    @Autowired
    public TestSpringServiceImpl(TestSpringRepository testSpringRepository) {
        this.testSpringRepository = testSpringRepository;
    }

    @Override
    public TestSpring addTestSpring(String name, String description) {
        // 새로운 TestSpring 객체 생성
        TestSpring testSpring = new TestSpring();
        testSpring.setName(name);
        testSpring.setDescription(description);

        // 데이터베이스에 저장
        return testSpringRepository.save(testSpring);
    }
}
