package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	// 내장된게 있는데 이거 왜함?
	// ViewResolver 여러개 해야하는 경우 필요할지도~
	
	// application.properties에 기록된거 직접 가져오자
	@Value("${spring.mvc.view.prefix")
	private String prefix;
	@Value("${spring.mvc.view.suffix")
	private String suffix;
	
	// 추후에 관심있다면 파일 다운로드 처리해보자
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("WEB-INF/views");
//		resolver.setSuffix(".jsp");
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	// 모든 요청은 여길 먼저 뒤져보고 가라
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
	// 등록할 인터셉터가 있다면
	// 필드를 통해 의존성을 주입받고
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//등록하면 된당..
	}
	
}
