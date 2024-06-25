package uz.bellissimo.g34springbootcaching.domain.user;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Company {
    @Column(name = "company_name")
    private String name;
    private String catchPhrase;
    private String bs;
}

