package data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "projects")
@Entity
@Data
@NoArgsConstructor
public class Projects {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    public Projects(String projectName, String projectDescription, LocalDate dateCreation) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.dateCreation = dateCreation;
    }
}
