package org.example.hibernate.secondary_table_example;

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

    @Embedded // Aby se mi nezaložila samostatná tabulka
    private Person person;

    @Column(table = "specialization")
    private String type;
}
