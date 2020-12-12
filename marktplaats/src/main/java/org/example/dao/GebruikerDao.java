package org.example.dao;

import org.example.domain.Gebruiker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GebruikerDao extends Dao<Gebruiker> {

    @PersistenceContext
    private EntityManager entityManager;
}
