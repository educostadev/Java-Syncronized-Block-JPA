package dev.educosta.masking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyService {

    @Autowired
    MyRepository repository;

    final Object lock = new Object();

    List<MyEntity> readAll() {
        return repository.findAll();
    }

    public void saveOne() {
        synchronized (lock) {
            var maxId = repository.findMax();
            var entity = MyEntity.create(maxId + 1);
            repository.save(entity);
        }
    }
}
