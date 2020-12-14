package org.example.dao;

import org.example.domain.Gebruiker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GebruikerDao extends Dao<Gebruiker> {

    @PersistenceContext
    private EntityManager entityManager;

    public Gebruiker authenticatie(String gebruikersnaam, String wachtwoord) {
        TypedQuery<Gebruiker> query = entityManager.createQuery("SELECT g FROM Gebruiker g WHERE g.gebruikersnaam = :gebruikersnaam AND g.wachtwoord = :wachtwoord", Gebruiker.class);
        query.setParameter("gebruikersnaam", gebruikersnaam);
        query.setParameter("wachtwoord", wachtwoord);
        Gebruiker gebruiker = query.getSingleResult();

        if (gebruiker == null) throw new SecurityException("Ongeldige gebruikersnaam/wachtwoord");

        return gebruiker;
    }


}
