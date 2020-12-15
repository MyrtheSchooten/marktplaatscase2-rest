package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "ProductAdvertentie.findAll", query = "select a from Advertentie a")
public class Advertentie {

    @Id
    @GeneratedValue
    String id;

    private String titel;
    private double prijs;
    private String omschrijving;
    private String soortAdvertentie;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Gebruiker eigenaar;
}
