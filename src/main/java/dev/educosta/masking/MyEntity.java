package dev.educosta.masking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Table(name = "MyTable")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyEntity {

    @Id
    private UUID uuid;

    @Column
    private Long id;

    @Column
    private String name;

    public static MyEntity create(long id){
        return new MyEntity(UUID.randomUUID(), id, ""+ id);
    }


}
