package app.weather.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.weather.home.entity.LocationInfo;
import app.weather.home.repository.LocationInfoRepository;

public class LocationInfoService {
	@Autowired
	private LocationInfoRepository locationInfoRepository;

	@GetMapping(path = "/all", produces = "application/json")
	List<LocationInfo> findAll() {
		return locationInfoRepository.findAll();
	}

	@GetMapping("/latitude/{latitude}/longitude/{longitude}")
	LocationInfo findCityByLatitudeAndLongitude(@PathVariable("latitude") Double latitude,
			@PathVariable("longitude") Double longitude) {
		return locationInfoRepository.findCityByLatitudeAndLongitude(latitude, longitude);
	}

	@ResponseBody
	@PostMapping("/")
	public void insertLocationInfo(LocationInfo locationInfo) {
		locationInfoRepository.save(locationInfo);
	}

	@ResponseBody
	@PostMapping("/id/{id}")
	public void updateLocationInfo(LocationInfo locationInfo) {
		locationInfoRepository.saveAndFlush(locationInfo);

	}

	@ResponseBody
	@DeleteMapping("/id/{id}")
	public void deleteLocationInfo(@PathVariable Long id) {
		locationInfoRepository.deleteById(id);
	}


}
