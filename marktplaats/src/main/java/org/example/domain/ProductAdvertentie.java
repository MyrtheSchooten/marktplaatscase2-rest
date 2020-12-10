package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@NamedQuery(name = "ProductAdvertentie.findAll", query = "select p from ProductAdvertentie p")
public class ProductAdvertentie extends Advertentie {
}
