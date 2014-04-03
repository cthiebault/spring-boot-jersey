package com.github.cthiebault.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.cthiebault.rest.UsersResource;
import com.github.cthiebault.service.UserService;

/**
 * Date: 31/01/2014
 * Time: 00:41
 *
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Configuration
@ComponentScan(basePackageClasses = { UsersResource.class, UserService.class })
public class TestConfig {}
