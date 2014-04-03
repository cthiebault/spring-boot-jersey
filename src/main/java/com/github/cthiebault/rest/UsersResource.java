package com.github.cthiebault.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.ApplicationContext;

import com.github.cthiebault.domain.User;
import com.github.cthiebault.service.UserService;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/users")
public class UsersResource {

  @Inject
  private UserService userService;

  @Inject
  private ApplicationContext applicationContext;

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

  @Path("/{name}")
  public UserResource getUser(@PathParam("name") String name) {
    UserResource userResource = applicationContext.getBean(UserResource.class);
    userResource.setName(name);
    return userResource;
  }

}
