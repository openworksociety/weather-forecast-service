package app.weather.home.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.weather.home.entity.HourlyWeatherInfo;
import app.weather.home.entity.LocationInfo;
import app.weather.home.repository.HourlyWeatherInfoRepository;
import app.weather.home.repository.LocationInfoRepository;

public class HourlyWeatherInfoService {

	@Autowired
	private HourlyWeatherInfoRepository hourlyWeatherInfoRepository;

	@Autowired
	private LocationInfoRepository locationInfoRepository;

	@ResponseBody
	@GetMapping("/city/{city}")
	public List<HourlyWeatherInfo> findWeatherByCity(@PathVariable String city) {
		return hourlyWeatherInfoRepository.findByCityIgnoreCase(city);
	}

	// Call this API : localhost:8080/api/weather/hourly/city/hamburg/future/2
	@ResponseBody
	@GetMapping("/city/{city}/future/{noOfFutureHours}")
	public List<HourlyWeatherInfo> findFutureHourWeatherByCity(@PathVariable String city,
			@PathVariable Integer noOfFutureHours) {
		int hourOfTheDay = getHourOfTheDay();
		return hourlyWeatherInfoRepository.findByCityIgnoreCaseAndHourCountBetween(city, hourOfTheDay,
				hourOfTheDay + noOfFutureHours);
	}
	
	// Call this API : localhost:8080/api/weather/hourly/city/hamburg/future/2
		@ResponseBody
		@GetMapping("/city/{city}/past/{noOfPastHours}")
		public List<HourlyWeatherInfo> findPastHourWeatherByCity(@PathVariable String city,
				@PathVariable Integer noOfPastHours) {
			int hourOfTheDay = getHourOfTheDay();
			return hourlyWeatherInfoRepository.findByCityIgnoreCaseAndHourCountBetween(city, hourOfTheDay-noOfPastHours,
					hourOfTheDay);
		}

	private int getHourOfTheDay() {
		Date date = new Date(); // given date
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date); // assigns calendar to given date
		int hourOfTheDay = calendar.get(Calendar.HOUR_OF_DAY);
		return hourOfTheDay;
	}

	// Call this API :
	// localhost:8080/api/weather/hourly/latitude/10.567/longitude/21.23
	@ResponseBody
	@GetMapping("/latitude/{latitude}/longitude/{longitude}")
	public List<HourlyWeatherInfo> findByCoOrdinates(@PathVariable Double latitude, @PathVariable Double longitude) {
		LocationInfo locationInfo = locationInfoRepository.findCityByLatitudeAndLongitude(latitude, longitude);
		return hourlyWeatherInfoRepository.findByCityIgnoreCase(locationInfo.getCity());
	}

	@ResponseBody
	@GetMapping(path = "/all", produces = "application/json")
	public List<HourlyWeatherInfo> findAllDailyWeatherInfo() {
		return hourlyWeatherInfoRepository.findAll();
	}
	
	@ResponseBody
	@PostMapping("/")
	public void insertHourlyWeatherInfo(HourlyWeatherInfo hourlyWeatherInfo) {
		hourlyWeatherInfoRepository.save(hourlyWeatherInfo);
	}

	@ResponseBody
	@PostMapping("/updateHourlyWeatherInfo")
	public void updateHourlyWeatherInfo(HourlyWeatherInfo hourlyWeatherInfo) {
		hourlyWeatherInfoRepository.saveAndFlush(hourlyWeatherInfo);
	}

	@ResponseBody
	@DeleteMapping("/id/{id}")
	public void deleteHourlyWeatherInfo(@PathVariable Long id) {
		hourlyWeatherInfoRepository.deleteById(id);
	}


}
