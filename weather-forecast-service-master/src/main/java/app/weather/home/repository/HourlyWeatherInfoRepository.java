package app.weather.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.weather.home.entity.HourlyWeatherInfo;

@Repository
public interface HourlyWeatherInfoRepository extends JpaRepository<HourlyWeatherInfo, Long> {


	List<HourlyWeatherInfo> findByCityIgnoreCaseAndHourCountBetween(@Param("city") String city, @Param("startHour") Integer startHour,
			@Param("endHour") Integer endHour);
	
	List<HourlyWeatherInfo> findByCityIgnoreCase(@Param("city") String city);
}
