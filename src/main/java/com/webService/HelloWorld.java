package com.webService;



import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by zhangtuoyu on 2017/6/19.
 */
@Path("/hello")
public interface HelloWorld {
    @GET
    @Path("/sayHello")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String sayHello(@FormParam("msg")String msg);
}
