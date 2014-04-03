package com.github.cthiebault.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/")
public class HelloResource {

  @GET
  @Path("/hello")
  @Produces(APPLICATION_JSON)
  public String hello() {
    return "Hello World";
  }

  @GET
  @Path("/exception")
  public String exception() {
    throw new RuntimeException("He's dead Jim");
  }
}
