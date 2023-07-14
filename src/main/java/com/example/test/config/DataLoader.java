package com.example.test.config;

import com.example.test.entity.LoggingСhanges;
import com.example.test.repository.LoggingСhangesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final LoggingСhangesRepository loggingСhangesRepository;

    @Autowired
    public DataLoader(LoggingСhangesRepository loggingСhangesRepository) {
        this.loggingСhangesRepository = loggingСhangesRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LoggingСhanges loggingСhanges = new LoggingСhanges();
        loggingСhanges.setCount(0L);
        loggingСhangesRepository.save(loggingСhanges);
    }
}
