package mx.com.oxsoftware.dxesoft.resources;

import mx.com.oxsoftware.dxesoft.model.entities.contact.Contact;
import mx.com.oxsoftware.dxesoft.service.contact.ContactService;
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
public class ContactResource {

    @Autowired
    ContactService contactService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactResource.class);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(Contact contact) {
        LOGGER.debug("Creating a contact");
        contactService.createContact(contact);

        return Response.status(Response.Status.CREATED).entity(contact).build();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Response getContactById(@PathParam("id")long id) {
        LOGGER.debug("search contact by id");
        Contact contact = contactService.findById(id);

        return Response.status(Response.Status.OK).entity(contact).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response getAll() {
        LOGGER.debug("get all contacts");

        Iterable<Contact> contacts = contactService.findAll();

        return Response.status(Response.Status.OK).entity(contacts).build();
    }

}
