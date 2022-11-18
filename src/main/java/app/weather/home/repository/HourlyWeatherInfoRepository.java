package app.weather.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.weather.home.entity.HourlyWeatherInfo;

@Repository
public interface HourlyWeatherInfoRepository extends JpaRepository<HourlyWeatherInfo, Long> {

}
