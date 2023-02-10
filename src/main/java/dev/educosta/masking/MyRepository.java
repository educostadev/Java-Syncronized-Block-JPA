package dev.educosta.masking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {


    @Query("select max(t.id) from MyEntity t")
    Long findMax();

}
