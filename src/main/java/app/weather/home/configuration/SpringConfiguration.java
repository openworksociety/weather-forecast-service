package app.weather.home.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "app.weather.home.*")
@EnableAutoConfiguration
public class SpringConfiguration {

}
