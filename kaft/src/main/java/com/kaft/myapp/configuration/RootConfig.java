package com.kaft.myapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"com.kaft"}, excludeFilters={
		@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
})
public class RootConfig {

}
