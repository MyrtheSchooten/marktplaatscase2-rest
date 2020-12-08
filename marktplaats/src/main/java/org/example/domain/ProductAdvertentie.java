package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class ProductAdvertentie extends Advertentie {
}
