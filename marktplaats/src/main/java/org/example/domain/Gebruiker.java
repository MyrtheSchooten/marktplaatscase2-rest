package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

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

}
