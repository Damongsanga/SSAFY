package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	

	// 모든 요청은 여길 먼저 뒤져보고 가라
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		
		registry.addResourceHandler("/swagger-ui/**") //이 요청은 swagger요청임을 명시
				.addResourceLocations("classpath:/META_INF/resources/webjars/springfox-swagger-ui/");
	}
	
	// 등록할 인터셉터가 있다면
	// 필드를 통해 의존성을 주입받고
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//등록하면 된당..
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}
	
}
