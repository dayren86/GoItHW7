package data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "companies")
@Entity
@Data
@NoArgsConstructor
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name ="it_companies")
    String itCompanies;

    @Column(name = "company_Description")
    String companyDescription;

    public Companies(String itCompanies, String companyDescription) {
        this.itCompanies = itCompanies;
        this.companyDescription = companyDescription;
    }
}
