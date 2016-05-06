package io.github.douglasjunior.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Douglas
 */
@ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();
        singletons.add(new JacksonFeature());
        singletons.add(new JacksonJaxbJsonProvider());
        singletons.add(new JacksonJsonProvider());
        return singletons;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper.class);
        resources.add(com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JsonMappingExceptionMapper.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JsonParseExceptionMapper.class);
        resources.add(io.github.douglasjunior.rest.PessoaResource.class);
        resources.add(io.github.douglasjunior.rest.TesteResource.class);
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
    }

}
