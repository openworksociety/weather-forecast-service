package app.weather.home.configuration;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import app.weather.home.controller.DailyWeatherInfoController;
import app.weather.home.controller.HourlyWeatherController;
import app.weather.home.controller.LocationInfoController;

@Profile("test")
@TestConfiguration
public class WeatherForecastServiceApplicationTestConfiguration {
//	@Bean("dailyWeatherInfoController")
//	public DailyWeatherInfoController dailyWeatherInfoController() {
//		return Mockito.mock(DailyWeatherInfoController.class);
//	}
//
//	@Bean("locatInfoController")
//	public LocationInfoController locatInfoController() {
//		return Mockito.mock(LocationInfoController.class);
//	}
//
//	@Bean("hourlyWeatherController")
//	public HourlyWeatherController hourlyWeatherController() {
//		return Mockito.mock(HourlyWeatherController.class);
//	}
}
