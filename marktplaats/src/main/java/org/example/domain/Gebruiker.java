package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Data
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Gebruiker.findAll", query = "select g from Gebruiker g")
public class Gebruiker {

    @Id
    @GeneratedValue
    String id;

    private String gebruikersnaam;
    private String wachtwoord;

/*    @OneToMany(mappedBy = "gebruiker", fetch = FetchType.EAGER)
    private List<Advertentie> advertenties;*/

}
