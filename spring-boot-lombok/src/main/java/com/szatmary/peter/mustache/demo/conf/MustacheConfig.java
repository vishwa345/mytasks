package com.szatmary.peter.mustache.demo.conf;

import com.github.mjeanroy.springmvc.view.mustache.configuration.EnableMustache;
import com.github.mjeanroy.springmvc.view.mustache.configuration.MustacheProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by nue on 14.6.2016.
 */
@Configuration
@EnableWebMvc
@EnableMustache(provider = MustacheProvider.AUTO)
@ComponentScan("com.szatmary.peter.mustache.demo")
public class MustacheConfig {
}