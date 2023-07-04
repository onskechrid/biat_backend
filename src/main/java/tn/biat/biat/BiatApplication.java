package tn.biat.biat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.python.util.PythonInterpreter;
import tn.biat.biat.services.IFunctionService;
import tn.biat.biat.utils.PythonRunner;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@CrossOrigin(origins = "*")
public class BiatApplication{

	public static void main(String[] args) {
		SpringApplication.run(BiatApplication.class, args);
	}

	public static Map<String, List<String>> dbSchemeMap;
	@Autowired
	private IFunctionService functionService;

	@PostConstruct
	public void init() {
		dbSchemeMap = functionService.getDatabaseSchema();
		System.err.println(dbSchemeMap.toString());
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedHeaders("File-Name");
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

	@Bean
	public PythonInterpreter pythonInterpreter() {
		return new PythonInterpreter();
	}
}
