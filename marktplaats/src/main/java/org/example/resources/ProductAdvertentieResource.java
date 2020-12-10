package org.example.resources;

import org.example.dao.AdvertentieDao;
import org.example.domain.ProductAdvertentie;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("productadvertenties")
@Produces(MediaType.APPLICATION_JSON)
public class ProductAdvertentieResource {

    @Inject
    private AdvertentieDao dao;

    @GET
    public Collection<ProductAdvertentie> getAllProducten() {
        return dao.getAllProducten();
    }

    @POST
    public ProductAdvertentie post(ProductAdvertentie p) {
        try {
            dao.add(p);
            return p;
        } catch (RuntimeException e) {
            throw new RuntimeException("Post contact" + p + "failed.");
        }
    }
}
