/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bilal Siddiqui
 */
@ApplicationPath("api")
public class App extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//        classes.add(JacksonJsonProvider.class);
//        return classes;
//    }
//
    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> resources = new java.util.HashSet<>();

        System.out.println("REST configuration starting: getClasses()");

        //features
        //this will register Jackson JSON providers
        resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);
        //we could also use this:
        //resources.add(com.fasterxml.jackson.provider.json.JacksonJaxbJsonProvider.class);

        //instead let's do it manually:
        resources.add(com.binprogramming.npmanager.ws.provider.JacksonJsonProvider.class);
//        resources.add(com.binprogramming.npmanager.ws.ui.entrypoints.UsersEntryPoint.class);
//        resources.add(com.binprogramming.npmanager.ws.ui.entrypoints.MessageResource.class);
//        resources.add(com.binprogramming.npmanager.ws.ui.entrypoints.PersonResource.class);
        //==> we will instead choose packages, see below getProperties()

        System.out.println("REST configuration ended successfully.");

        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();

        //in Jersey WADL generation is enabled by default, but we don't
        //want to expose too much information about our apis.
        //therefore we want to disable wadl (http://localhost:8080/service/application.wadl should return http 404)
        //see https://jersey.java.net/nonav/documentation/latest/user-guide.html#d0e9020 for details
        //properties.put("jersey.config.server.wadl.disableWadl", true);

        //we can also use something like this instead of adding each of our resources
        //explicitly in getClasses():
        properties.put("jersey.config.server.provider.packages", "com.binprogramming.npmanager.ws.ui");

        return properties;
    }

}
