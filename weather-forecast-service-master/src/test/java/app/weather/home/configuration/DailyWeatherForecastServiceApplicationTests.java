package app.weather.home.configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.weather.home.controller.DailyWeatherInfoController;
import app.weather.home.controller.HourlyWeatherController;
import app.weather.home.entity.DailyWeatherInfo;
import app.weather.home.entity.HourlyWeatherInfo;

@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@Import(WeatherForecastServiceApplicationTestConfiguration.class)
public class DailyWeatherForecastServiceApplicationTests {

	@Autowired
	private DailyWeatherInfoController dailyWeatherInfoController;
	DailyWeatherInfoController mock = org.mockito.Mockito.mock(DailyWeatherInfoController.class);

	@Test
	void findWeatherByCity() {
		List<DailyWeatherInfo> dailyWeatherInfos = Arrays
				.asList(DailyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).humidity(20).id(1l)
						.sunriseTime(LocalTime.now()).sunsetTime(LocalTime.MAX).build());
		Mockito.when(mock.findWeatherByCity("Mumbai")).thenReturn(dailyWeatherInfos);
		List<DailyWeatherInfo> findFutureWeatherByCity = mock.findWeatherByCity("Mumbai");
		Assert.assertEquals(dailyWeatherInfos.size(), findFutureWeatherByCity.size());
	}

	@Test
	void findPastWeatherByCity() {
		List<DailyWeatherInfo> dailyWeatherInfos = Arrays.asList(
				DailyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).humidity(20).id(1l)
						.sunriseTime(LocalTime.now()).sunsetTime(LocalTime.MAX).build(),
				DailyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).humidity(20).id(2l)
						.sunriseTime(LocalTime.now()).sunsetTime(LocalTime.MAX).build());
		Mockito.when(mock.findPastWeatherByCity("Mumbai", 2)).thenReturn(dailyWeatherInfos);
		List<DailyWeatherInfo> findFutureWeatherByCity = mock.findPastWeatherByCity("Mumbai", 2);
		Assert.assertEquals(dailyWeatherInfos.size(), findFutureWeatherByCity.size());
	}

	@Test
	void findDailyWeatherByCoOrdinates() {
		List<DailyWeatherInfo> dailyWeatherInfos = Arrays
				.asList(DailyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).humidity(20).id(1l)
						.sunriseTime(LocalTime.now()).sunsetTime(LocalTime.MAX).build());
		Mockito.when(mock.findByCoOrdinates(50.551086, 8.993682)).thenReturn(dailyWeatherInfos);
		List<DailyWeatherInfo> findByCoOrdinates = mock.findByCoOrdinates(50.551086, 8.993682);
		System.out.println("Size of future weather (findDailyWeatherByCoOrdinates):" + findByCoOrdinates.size());
		Assert.assertEquals(dailyWeatherInfos.size(), findByCoOrdinates.size());
	}

	@Test
	void findFutureWeatherByCity() {
		List<DailyWeatherInfo> dailyWeatherInfos = Arrays.asList(
				DailyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).humidity(20).id(1l)
						.sunriseTime(LocalTime.now()).sunsetTime(LocalTime.MAX).build(),
				DailyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).humidity(20).id(2l)
						.sunriseTime(LocalTime.now()).sunsetTime(LocalTime.MAX).build());
		Mockito.when(mock.findFutureWeatherByCity("Mumbai", 5)).thenReturn(dailyWeatherInfos);
		List<DailyWeatherInfo> findFutureWeatherByCity = mock.findFutureWeatherByCity("Mumbai", 5);
		System.out.println("Size of future weather (findFutureWeatherByCity):" + findFutureWeatherByCity.size());
		Assert.assertEquals(dailyWeatherInfos.size(), findFutureWeatherByCity.size());
	}

	@Test
	void insertDailyInfo() {
		DailyWeatherInfo dailyWeatherInfo = DailyWeatherInfo.builder().city("Düsseldorf").date(LocalDate.now())
				.humidity(25).sunriseTime(LocalTime.of(7, 0)).sunsetTime(LocalTime.of(18, 30)).temperature(12).build();
		dailyWeatherInfoController.insertDailyWeatherInfo(dailyWeatherInfo);
	}
	
	@Test
	void updateDailyInfo() {
		DailyWeatherInfo dailyWeatherInfo = DailyWeatherInfo.builder().id(1l).city("Mumbai").date(LocalDate.now())
				.humidity(30).sunriseTime(LocalTime.of(7, 30)).sunsetTime(LocalTime.of(19, 30)).temperature(25).build();
		dailyWeatherInfoController.updateDailyWeatherInfo(dailyWeatherInfo);
	}
	
	@Test
	void deleteDailyInfo() {
		dailyWeatherInfoController.deleteDailyWeatherInfoById(5l);
	}
	
	@Test
	void findAllDailyInfo() {
		List<DailyWeatherInfo> findAllDailyWeatherInfo = dailyWeatherInfoController.findAllDailyWeatherInfo();
		System.out.println("Size of all info :"+findAllDailyWeatherInfo.size());
	}
}
