package com.github.cthiebault.rest;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloResourceTest extends JerseyTest {

  private static final Logger log = LoggerFactory.getLogger(UsersResourceTest.class);

  @Override
  protected Application configure() {
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
    return new JerseyConfig().property("contextConfig", context);
  }

}
