package dev.educosta.masking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MyRepository myRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        myRepository.save(new MyEntity(UUID.randomUUID(),98000001L, "FIRST-RECORD"));
    }
}
