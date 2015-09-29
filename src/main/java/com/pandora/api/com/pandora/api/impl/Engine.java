package com.pandora.api.com.pandora.api.impl;

import com.pandora.api.services.EngineService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.lang.String;

/**
 * Created by developer on 9/28/15.
 */

@Path("/engine")
public class Engine {
    @Inject
    EngineService engineService;

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getFinalPriceJSON() {
        return "{\"result\":\"" + engineService.getFinalPrice() + "\"}";
    }
}
