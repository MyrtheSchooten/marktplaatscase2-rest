package org.example.resources;

import org.example.dao.AdvertentieDao;
import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("advertenties")
@Produces(MediaType.APPLICATION_JSON)
public class AdvertentieResource {

    @Inject
    private AdvertentieDao dao;

    @GET
    public Collection<Advertentie> getAllProducten() {
        return dao.getAllProducten();
    }

    @GET
    @Path("{id}")
    public Collection<Advertentie> getAllVanGebruiker (@PathParam("id") String id){
        return dao.getAllByGebruikerId(id);
    }

    @POST
    public Advertentie post(Advertentie a) {
        try {
            dao.add(a);
            return a;
        } catch (RuntimeException e) {
            throw new RuntimeException("Post product" + a + "failed.");
        }
    }

}
