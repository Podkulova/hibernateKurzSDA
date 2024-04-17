package org.example.secondary_table_example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher")
@SecondaryTable(name = "specialization")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    private int id;

/*    @Embedded
    private Person person;*/

    @Column(table = "specialization")
    private String type;
}
