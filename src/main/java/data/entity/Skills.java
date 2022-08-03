package data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "skills")
@Entity
@Data
@NoArgsConstructor
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "positions")
    private Position position;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level")
    private SkillLevel skillLevel;

    public Skills(Position position, SkillLevel skillLevel) {
        this.position = position;
        this.skillLevel = skillLevel;
    }

    public enum Position {
        Java,
        CSharp,
        JS,
        CPlus

    }

    public enum SkillLevel {
        Junior,
        Middle,
        Senior
    }
}


