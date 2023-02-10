package dev.educosta.masking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    MyService service;


    @PostMapping("/create")
    void fire() {
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    service.saveOne();
                }
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, task, "Thread-" + i);
            threads.add(thread);
        }
        threads.forEach(Thread::start);

        while (threadGroup.activeCount() != 0) {
        }
    }

    @GetMapping(path = "/all-duplicates")
    Object readAllDuplicated() {
        TreeSet<Long> values = new TreeSet<Long>();
        return service.readAll().stream()
                .filter(v -> !values.add(v.getId()))
                .map(MyEntity::getId).collect(Collectors.toSet());
    }

    @GetMapping(path = "/all")
    Object readAll() {
        TreeSet<Long> values = new TreeSet<Long>();
        return service.readAll().stream().map(MyEntity::getId).sorted().collect(Collectors.toList());
    }

    @GetMapping(path = "/records")
    Object records() {
        return (long) service.readAll().size();
    }

}
