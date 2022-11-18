package app.weather.home.configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.weather.home.controller.HourlyWeatherController;
import app.weather.home.entity.HourlyWeatherInfo;
import app.weather.home.repository.HourlyWeatherInfoRepository;
import app.weather.home.service.HourlyWeatherInfoService;

@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class HourlyWeatherForecastServiceTest {

	HourlyWeatherInfoService mockHourlyWeatherController = org.mockito.Mockito.mock(HourlyWeatherInfoService.class);
	
	@Autowired
	HourlyWeatherInfoService hourlyWeatherInfoRepository;

	@Test
	void findHourlyWeatherByCity() {
		List<HourlyWeatherInfo> hourlyWeatherInfo = Arrays.asList(
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(1).humidity(20).id(1l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(2).humidity(20).id(2l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(3).humidity(20).id(3l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(4).humidity(20).id(4l)
						.build());
		Mockito.when(mockHourlyWeatherController.findWeatherByCity("Mumbai")).thenReturn(hourlyWeatherInfo);
		List<HourlyWeatherInfo> findFutureWeatherByCity = mockHourlyWeatherController.findWeatherByCity("Mumbai");
		System.out.println("Size of future weather (findHourlyWeatherByCity):" + findFutureWeatherByCity.size());
		Assert.assertEquals(hourlyWeatherInfo.size(), findFutureWeatherByCity.size());
	}

	@Test
	void findFutureHourWeatherByCity() {
		List<HourlyWeatherInfo> hourlyWeatherInfo = Arrays.asList(
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(1).humidity(20).id(1l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(2).humidity(20).id(2l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(3).humidity(20).id(3l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(4).humidity(20).id(4l)
						.build());
		Mockito.when(mockHourlyWeatherController.findFutureHourWeatherByCity("Mumbai", 2))
				.thenReturn(hourlyWeatherInfo);
		List<HourlyWeatherInfo> findFutureWeatherByCity = mockHourlyWeatherController
				.findFutureHourWeatherByCity("Mumbai", 2);
		System.out.println("Size of future weather (findFutureHourlyWeatherByCity):" + findFutureWeatherByCity.size());
		Assert.assertEquals(hourlyWeatherInfo.size(), findFutureWeatherByCity.size());
	}

	@Test
	void findByCoOrdinates() {
		List<HourlyWeatherInfo> hourlyWeatherInfo = Arrays.asList(
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(1).humidity(20).id(1l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(2).humidity(20).id(2l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(3).humidity(20).id(3l)
						.build(),
				HourlyWeatherInfo.builder().city("Mumbai").date(LocalDate.now()).hourCount(4).humidity(20).id(4l)
						.build());
		Mockito.when(mockHourlyWeatherController.findByCoOrdinates(50.551086, 8.993682))
				.thenReturn(hourlyWeatherInfo);
		List<HourlyWeatherInfo> findFutureWeatherByCity = mockHourlyWeatherController.findByCoOrdinates(50.551086, 8.993682);
		Assert.assertEquals(hourlyWeatherInfo.size(), findFutureWeatherByCity.size());
	}
	
	@Test
	void findPastHourWeatherByCity() {
		List<HourlyWeatherInfo> findFutureWeatherByCity = hourlyWeatherInfoRepository.findPastHourWeatherByCity("Mumbai", 4);
		System.out.println("Size of future weather (findFutureHourlyWeatherByCity):" + findFutureWeatherByCity.size());
	}
}
