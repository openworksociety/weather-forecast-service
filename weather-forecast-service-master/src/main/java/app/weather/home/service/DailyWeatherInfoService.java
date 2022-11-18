package app.weather.home.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.weather.home.entity.DailyWeatherInfo;
import app.weather.home.entity.LocationInfo;
import app.weather.home.repository.DailyWeatherInfoRepository;
import app.weather.home.repository.LocationInfoRepository;

public class DailyWeatherInfoService {

	@Autowired
	private DailyWeatherInfoRepository dailyWeatherInfoRepository;

	@Autowired
	private LocationInfoRepository locationInfoRepository;

	@ResponseBody
	@GetMapping("/city/{city}")
	public List<DailyWeatherInfo> findWeatherByCity(@PathVariable String city) {
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDate(city, LocalDate.now());
	}

	// Call this API : localhost:8080/api/weather/daily/city/hamburg/past/2
	@ResponseBody
	@GetMapping("/city/{city}/past/{noOfPastDays}")
	public List<DailyWeatherInfo> findPastWeatherByCity(@PathVariable String city, @PathVariable Integer noOfPastDays) {
		LocalDate pastDate = LocalDate.now().minusDays(noOfPastDays);
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDateBetween(city, pastDate, LocalDate.now());
	}

	// Call this API : localhost:8080/api/weather/daily/city/hamburg/future/2
	@ResponseBody
	@GetMapping("/city/{city}/future/{noOfFutureDays}")
	public List<DailyWeatherInfo> findFutureWeatherByCity(@PathVariable String city,
			@PathVariable Integer noOfFutureDays) {
		LocalDate date = LocalDate.now().plusDays(noOfFutureDays);
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDateBetween(city, LocalDate.now(), date);
	}

	// Call this API :
	// localhost:8080/api/weather/daily/latitude/10.567/longitude/21.23
	@ResponseBody
	@GetMapping("/latitude/{latitude}/longitude/{longitude}")
	public List<DailyWeatherInfo> findByCoOrdinates(@PathVariable Double latitude, @PathVariable Double longitude) {
		LocationInfo locationInfo = locationInfoRepository.findCityByLatitudeAndLongitude(latitude, longitude);
		return dailyWeatherInfoRepository.findByCityIgnoreCaseAndDate(locationInfo.getCity(), LocalDate.now());
	}

	@ResponseBody
	@GetMapping(path = "/all", produces = "application/json")
	public List<DailyWeatherInfo> findAllDailyWeatherInfo() {
		return dailyWeatherInfoRepository.findAll();
	}

	@ResponseBody
	@PostMapping("/")
	public void insertDailyWeatherInfo(DailyWeatherInfo dailyWeatherInfo) {
		dailyWeatherInfoRepository.save(dailyWeatherInfo);
	}

	@ResponseBody
	@PostMapping("/updateDailyWeatherInfo")
	public void updateDailyWeatherInfo(DailyWeatherInfo dailyWeatherInfo) {
		dailyWeatherInfoRepository.saveAndFlush(dailyWeatherInfo);

	}

	@ResponseBody
	@DeleteMapping("/id/{id}")
	public void deleteDailyWeatherInfoById(@PathVariable Long id) {
		dailyWeatherInfoRepository.deleteById(id);
	}
}
