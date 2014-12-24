package mx.com.oxsoftware.dxesoft.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by ernesto on 12/23/14.
 *
 * Jersey configuration
 */
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        packages("mx.com.oxsoftware.dxesoft.resources");
        register(LoggingFilter.class);
        register(JacksonFeature.class);
        register(RequestContextFilter.class);
    }
}
