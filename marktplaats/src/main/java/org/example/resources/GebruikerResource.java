package org.example.resources;

import org.example.dao.GebruikerDao;
import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("gebruikers")
@Produces(MediaType.APPLICATION_JSON)
public class GebruikerResource {

    @Inject
    private GebruikerDao dao;


    @GET
    public Collection<Gebruiker> getAllGebruikers() {
        return dao.getAll();
    }

    @POST
    public Gebruiker post(Gebruiker g) {
        try {
            dao.add(g);
            return g;
        } catch (RuntimeException e) {
            throw new RuntimeException("Post contact" + g + "failed.");
        }
    }

    public GebruikerDao getDao(){
        return (GebruikerDao) this.dao;
    }

    @POST
    @Path("login")
    public Gebruiker login(Gebruiker g){
        try {
            String gebruikersnaam = g.getGebruikersnaam();
            String wachtwoord = g.getWachtwoord();

            Gebruiker gebruiker = getDao().authenticatie(gebruikersnaam, wachtwoord);

            return gebruiker;
        } catch (Exception e){
            throw new NotAuthorizedException("Gebruiker" + g + "is niet geautoriseerd", e);
        }
    }

}
