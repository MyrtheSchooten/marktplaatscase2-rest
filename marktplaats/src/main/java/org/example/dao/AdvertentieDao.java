package org.example.dao;


import org.example.domain.Advertentie;
import org.example.domain.ProductAdvertentie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AdvertentieDao extends Dao<Advertentie> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductAdvertentie> getAllProducten() {
        return entityManager.createNamedQuery("ProductAdvertentie.findAll", ProductAdvertentie.class).getResultList();
    }

}
