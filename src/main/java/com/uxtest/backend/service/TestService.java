package com.uxtest.backend.service;

import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.uxmodel.UxModel;
import com.uxtest.backend.repository.TaskRepository;
import com.uxtest.backend.repository.TestRepository;
import com.uxtest.backend.repository.UxModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public Test getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found"));
    }


    public void createTest(Test test) {
        test.getUxModel().getTests().add(test);
        test.getTasks().forEach(task->task.setTest(test));
//        test.getCreator().addTest(test);
        testRepository.save(test);
    }

    public void updateTest(Test test, Long id) {
        if (testRepository.existsById(id)) {
            test.setId(id);
            testRepository.save(test);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }

    public List<Test> getTests() {
        return testRepository.findAll();
    }
}
