package org.example.dao;


import org.example.domain.Advertentie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdvertentieDao extends Dao<Advertentie> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Advertentie> getAllProducten() {
        return entityManager.createNamedQuery("ProductAdvertentie.findAll", Advertentie.class).getResultList();
    }

}
