package org.example.resources;

import org.example.dao.AdvertentieDao;
import org.example.domain.DienstAdvertentie;
import org.example.domain.ProductAdvertentie;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("dienstadvertenties")
@Produces(MediaType.APPLICATION_JSON)
public class DienstAdvertentiesResource {
    @Inject
    private AdvertentieDao dao;

    @GET
    public Collection<DienstAdvertentie> getAllDiensten() {
        return dao.getAllDiensten();
    }
}
