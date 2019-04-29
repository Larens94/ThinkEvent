package it.thinkevent;

import it.thinkevent.utilis.CorsFilter;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThinkEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkEventApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean corsFilterRegistratio(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CorsFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public BasicTextEncryptor textEncryptor(){
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("keyPrivate");
		return textEncryptor;
	}
}
