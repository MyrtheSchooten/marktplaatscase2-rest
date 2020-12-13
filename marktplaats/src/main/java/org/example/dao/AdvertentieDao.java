package org.example.dao;


import org.example.domain.Advertentie;
import org.example.domain.DienstAdvertentie;
import org.example.domain.ProductAdvertentie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdvertentieDao extends Dao<Advertentie> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductAdvertentie> getAllProducten() {
        return entityManager.createNamedQuery("ProductAdvertentie.findAll", ProductAdvertentie.class).getResultList();
    }

    public List<DienstAdvertentie> getAllDiensten() {
        return entityManager.createNamedQuery("DienstAdvertentie.findAll", DienstAdvertentie.class).getResultList();
    }

}
