package mx.com.oxsoftware.dxesoft.resources;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import mx.com.oxsoftware.dxesoft.service.Contacto.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.*;

/**
 * Date: 12/27/14
 * User: ernesto
 */
@Path("/contacts")
@Component
public class ContactoResource {

    @Autowired
    ContactoService contactoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactoResource.class);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(Contacto contacto) {
        LOGGER.debug("Creating a contact");
        contactoService.createContacto(contacto);

        return Response.status(Response.Status.CREATED).entity(contacto).build();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Response getContactById(@PathParam("id")long id) {
        LOGGER.debug("search contact by id");
        Contacto contacto = contactoService.findById(id);

        return Response.status(Response.Status.OK).entity(contacto).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response getAll() {
        LOGGER.debug("get all contacts");

        Iterable<Contacto> contactos = contactoService.findAll();

        return Response.status(Response.Status.OK).entity(contactos).build();
    }

}
