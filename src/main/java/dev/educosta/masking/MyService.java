package dev.educosta.masking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyService {

    @Autowired
    MyRepository repository;

    List<MyEntity> readAll(){
        return repository.findAll();
    }

    public void saveOne() {
        var maxId = repository.findMax();
        var entity = MyEntity.create(maxId+1);
        repository.save(entity);
    }
}
