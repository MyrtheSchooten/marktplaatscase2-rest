package org.example.dao;


import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AdvertentieDao extends Dao<Advertentie> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Advertentie> getAllProducten() {
        return entityManager.createNamedQuery("ProductAdvertentie.findAll", Advertentie.class).getResultList();
    }

    public List<Advertentie> getAllByGebruikerId(String id){
        TypedQuery<Advertentie> query = entityManager.createQuery("SELECT e FROM Advertentie  e WHERE e.eigenaar.id = :id", Advertentie.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

}
