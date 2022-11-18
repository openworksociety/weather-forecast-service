package app.weather.home.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.weather.home.entity.DailyWeatherInfo;
import app.weather.home.repository.DailyWeatherInfoRepository;

@RestController
@RequestMapping(path = "/api/weather/daily")
public class DailyWeatherInfoController {

	@Autowired
	private DailyWeatherInfoRepository dailyWeatherInfoRepository;

	@ResponseBody
	@GetMapping("/city/{city}")
	List<DailyWeatherInfo> findWeatherByCity(@PathVariable String city) {
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDate(city, LocalDate.now());
	}

	// Call this API : localhost:8080/api/weather/daily/city/hamburg/past/2
	@ResponseBody
	@GetMapping("/city/{city}/past/{noOfPastDays}")
	List<DailyWeatherInfo> findPastWeatherByCity(@PathVariable String city, @PathVariable Integer noOfPastDays) {
		LocalDate pastDate = LocalDate.now().minusDays(noOfPastDays);
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDateBetween(city, pastDate, LocalDate.now());
	}

	// Call this API : localhost:8080/api/weather/daily/city/hamburg/future/2
	@ResponseBody
	@GetMapping("/city/{city}/future/{noOfFutureDays}")
	List<DailyWeatherInfo> findFutureWeatherByCity(@PathVariable String city, @PathVariable Integer noOfFutureDays) {
		LocalDate date = LocalDate.now().plusDays(noOfFutureDays);
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDateBetween(city, LocalDate.now(), date);
	}

	// Call this API :
	// localhost:8080/api/weather/daily/latitude/10.567/longitude/21.23
	@ResponseBody
	@GetMapping("/latitude/{latitude}/longitude/{longitude}")
	List<DailyWeatherInfo> findByCoOrdinates(@PathVariable Double latitude, @PathVariable Double longitude) {
		// TODO
		return null;
	}

}
