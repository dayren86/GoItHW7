package data.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "developers_skills",
            joinColumns = { @JoinColumn(name = "developers_id") },
            inverseJoinColumns = { @JoinColumn(name = "skills_id") }
    )
    private Set<Skills> skillsSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "developers_projects",
            joinColumns = { @JoinColumn(name = "developers_id") },
            inverseJoinColumns = { @JoinColumn(name = "projects_id") }
    )
    private Set<Projects> projectsSet;

    public Developers(String name, int age, Sex sex, int salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public enum Sex {
        MALE,
        FEMALE,
        UNKNOWN
    }
}
