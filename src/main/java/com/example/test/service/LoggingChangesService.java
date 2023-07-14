package com.example.test.service;

import com.example.test.entity.LoggingСhanges;
import com.example.test.repository.LoggingСhangesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LoggingChangesService {

    private final LoggingСhangesRepository loggingСhangesRepository;

    @Autowired
    public LoggingChangesService(LoggingСhangesRepository loggingСhangesRepository) {
        this.loggingСhangesRepository = loggingСhangesRepository;
    }

    public LoggingСhanges findFirstByOrderByIdDesc() {
        return loggingСhangesRepository.findFirstByOrderByIdDesc();
    }

    @Transactional
    public void incrementCount() {
        LoggingСhanges oldLoggingChanges = loggingСhangesRepository.findFirstByOrderByIdDesc();
        LoggingСhanges newLoggingСhanges = LoggingСhanges.builder()
                .count(oldLoggingChanges.getCount() + 1)
                .build();
        loggingСhangesRepository.save(newLoggingСhanges);
    }
}
