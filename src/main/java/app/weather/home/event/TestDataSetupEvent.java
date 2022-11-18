package app.weather.home.event;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import app.weather.home.entity.DailyWeatherInfo;
import app.weather.home.entity.HourlyWeatherInfo;
import app.weather.home.entity.LocationInfo;
import app.weather.home.repository.DailyWeatherInfoRepository;
import app.weather.home.repository.HourlyWeatherInfoRepository;
import app.weather.home.repository.LocationInfoRepository;

@Component
public class TestDataSetupEvent implements ApplicationListener<ContextRefreshedEvent> {

	boolean isSaved = false;

	@Autowired
	private LocationInfoRepository locationInfoRepository;

	@Autowired
	private DailyWeatherInfoRepository dailyWeatherInfoRepository;

	@Autowired
	private HourlyWeatherInfoRepository hourlyWeatherInfoRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (isSaved) {
			return;
		}

		locationInfoRepository.save(LocationInfo.builder().city("Hamburg").country("Germany").latitude(53.551086)
				.longitude(9.993682).build());
		locationInfoRepository.save(
				LocationInfo.builder().city("Latur").country("India").latitude(50.551086).longitude(8.993682).build());

		dailyWeatherInfoRepository.save(DailyWeatherInfo.builder().city("Latur").date(LocalDate.now()).humidity(30)
				.sunriseTime(LocalTime.of(6, 30)).sunsetTime(LocalTime.of(18, 30)).temperature(25).wind("10 Km/h")
				.build());
		dailyWeatherInfoRepository
				.save(DailyWeatherInfo.builder().city("Hamburg").date(LocalDate.now()).humidity(10).wind("10 Km/h")
						.sunriseTime(LocalTime.of(5, 30)).sunsetTime(LocalTime.of(19, 30)).temperature(25).build());

		hourlyWeatherInfoRepository.save(HourlyWeatherInfo.builder().city("Latur").date(LocalDate.now()).hourCount(1)
				.humidity(35).temperature(25).wind("10 Km/h").build());
		hourlyWeatherInfoRepository.save(HourlyWeatherInfo.builder().city("Latur").date(LocalDate.now()).hourCount(2)
				.humidity(35).temperature(25).wind("10 Km/h").build());
		hourlyWeatherInfoRepository.save(HourlyWeatherInfo.builder().city("Latur").date(LocalDate.now()).hourCount(3)
				.humidity(35).temperature(25).wind("10 Km/h").build());
		hourlyWeatherInfoRepository.save(HourlyWeatherInfo.builder().city("Latur").date(LocalDate.now()).hourCount(4)
				.humidity(35).temperature(25).wind("10 Km/h").build());

		// past dated daily weather
		for (int i = 1; i <= 5; i++) {
			dailyWeatherInfoRepository.save(DailyWeatherInfo.builder().city("Hamburg")
					.date(LocalDate.now().minusDays(i)).humidity(30).sunriseTime(LocalTime.of(6, 30))
					.sunsetTime(LocalTime.of(18, 30)).temperature(25).wind("10 Km/h").build());
		}

		// future dated daily weather
		for (int i = 1; i <= 5; i++) {
			dailyWeatherInfoRepository.save(DailyWeatherInfo.builder().city("Hamburg").date(LocalDate.now().plusDays(i))
					.humidity(30).sunriseTime(LocalTime.of(6, 30)).sunsetTime(LocalTime.of(18, 30)).temperature(25)
					.wind("10 Km/h").build());
		}

		isSaved = true;
	}

}
