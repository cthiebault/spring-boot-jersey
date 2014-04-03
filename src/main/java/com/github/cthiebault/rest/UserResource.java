package com.github.cthiebault.rest;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.cthiebault.domain.User;
import com.github.cthiebault.service.UserService;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Scope("request")
public class UserResource {

  @Inject
  private UserService userService;

  @NotNull
  private String name;

  public void setName(@NotNull String name) {
    this.name = name;
  }

  @GET
  @Produces(APPLICATION_JSON)
  public User get() {
    return userService.findByName(name);
  }

  @PUT
  @Produces(APPLICATION_JSON)
  public Response update(User user) {
    if(userService.findByName(name) == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    userService.addUser(user);
    return Response.noContent().build();
  }

  @DELETE
  public Response delete() {
    userService.deleteUser(name);
    return Response.noContent().build();
  }
}
