package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Advertentie {

    @Id
    @GeneratedValue
    String id;

    private String titel;
    private double prijs;

}
