package com.github.cthiebault.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.github.cthiebault.domain.User;
import com.github.cthiebault.service.UserService;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/users")
public class UsersResource {

  @Inject
  private UserService userService;

  @GET
  @Produces(APPLICATION_JSON)
  public Collection<User> list() {
    return userService.findAll();
  }

  @POST
  @Consumes(APPLICATION_JSON)
  public Response create(User user, @Context UriInfo uriInfo) {
    userService.addUser(user);
    return Response.created(uriInfo.getBaseUriBuilder().path(UserResource.class).build(user.getName())).build();
  }
}
