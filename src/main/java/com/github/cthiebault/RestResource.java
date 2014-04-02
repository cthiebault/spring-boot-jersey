package com.github.cthiebault;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/jersey")
public class RestResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String hello() {
    return "Hello World";
  }
}
