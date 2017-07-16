package com.kaft.myapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.kaft.myapp"}, excludeFilters={
		@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
})
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver(){
		return new TilesViewResolver();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{"/WEB-INF/**/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
}
