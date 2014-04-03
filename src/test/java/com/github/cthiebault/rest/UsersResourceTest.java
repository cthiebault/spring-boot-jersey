package com.github.cthiebault.rest;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.cthiebault.rest.config.JerseyConfig;
import com.github.cthiebault.rest.config.TestConfig;

public class UsersResourceTest extends JerseyTest {

  private static final Logger log = LoggerFactory.getLogger(UsersResourceTest.class);

  @Override
  protected Application configure() {
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
    return new JerseyConfig().property("contextConfig", context);
  }

  @Test
  public void test_get_hello() {
    String hello = target("hello").request().get(String.class);
    log.info("{}", hello);
  }

}
