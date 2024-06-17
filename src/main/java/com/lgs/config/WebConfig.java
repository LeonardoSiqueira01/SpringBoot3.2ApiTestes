package com.lgs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.MediaType;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
 //http://localhost:8081/person/v1?mediaType=xml
  // http://localhost:8081/person/v1/7?mediaType=xml
 //CONFIGURANDO VIA QUERY PARAM.
  
		configurer.favorParameter(true).parameterName("mediaType").ignoreAcceptHeader(true)
				.useRegisteredExtensionsOnly(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML);
	}*/
	

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		//CONFIGURANDO VIA HEADER PARAM.
		configurer.favorParameter(false).ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false).defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML);
	//Exemplos de chamadas
		 //http://localhost:8081/person/v1?mediaType=xml
		  //http://localhost:8081/person/v1/7?mediaType=xml
	}

}
