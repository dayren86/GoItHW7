package data.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "developers")
@Entity
@Data
@NoArgsConstructor
public class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column
    private int salary;

    public Developers(String name, int age, Sex sex, int salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public enum Sex {
        male,
        female,
        unknown
    }
}
