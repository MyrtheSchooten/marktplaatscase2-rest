package org.example.resources;

import org.example.dao.GebruikerDao;
import org.example.domain.Gebruiker;
import org.example.domain.ProductAdvertentie;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
