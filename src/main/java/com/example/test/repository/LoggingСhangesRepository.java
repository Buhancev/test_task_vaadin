package com.example.test.repository;

import com.example.test.entity.LoggingСhanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingСhangesRepository extends JpaRepository<LoggingСhanges, Long> {


    public LoggingСhanges findFirstByOrderByIdDesc();
}
