package app.weather.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.weather.home.entity.LocationInfo;
import app.weather.home.repository.LocationInfoRepository;

@RestController
@RequestMapping(path = "/api/location")
public class LocationInfoController {

	@Autowired
	private LocationInfoRepository locationInfoRepository;

	@GetMapping(path = "/all", produces = "application/json")
	List<LocationInfo> findAll() {
		return locationInfoRepository.findAll();
	}

}
