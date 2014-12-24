package mx.com.oxsoftware.dxesoft.resources;

import mx.com.oxsoftware.dxesoft.Hello;
import mx.com.oxsoftware.dxesoft.TestClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ernesto on 12/23/14.
 *
 * test
 */
@Path("/restresource")
@Component
public class RestResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public Hello hello() {
        Hello hello = new Hello();
        hello.setMessage("hola mundo");

        TestClass testClass = new TestClass();

        testClass.setSaludo("Emiliano");
        hello.setTestClass(testClass);
        return hello;
    }

    @POST
    @Path("/crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSomething (Hello hello) {
        LOGGER.debug("*************************************************************************************************************");
        LOGGER.debug(hello.getMessage() + hello.getTestClass().getSaludo());
        LOGGER.debug("*************************************************************************************************************");
        return Response.status(Response.Status.CREATED).entity(hello).build();
    }
}
