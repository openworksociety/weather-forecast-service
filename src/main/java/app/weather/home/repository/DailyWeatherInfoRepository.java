package app.weather.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.weather.home.entity.DailyWeatherInfo;

@Repository
public interface DailyWeatherInfoRepository extends JpaRepository<DailyWeatherInfo, Long> {

}
