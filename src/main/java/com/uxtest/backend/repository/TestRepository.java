package com.uxtest.backend.repository;

import com.uxtest.backend.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
