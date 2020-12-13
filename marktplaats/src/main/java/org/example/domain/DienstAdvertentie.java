package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Entity
@NamedQuery(name = "DienstAdvertentie.findAll", query = "select p from DienstAdvertentie p")
public class DienstAdvertentie extends Advertentie {
}
