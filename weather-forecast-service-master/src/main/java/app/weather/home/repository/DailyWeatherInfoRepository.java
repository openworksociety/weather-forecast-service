package app.weather.home.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.weather.home.entity.DailyWeatherInfo;

@Repository
public interface DailyWeatherInfoRepository extends JpaRepository<DailyWeatherInfo, Long> {

	List<DailyWeatherInfo> findByCityIgnoreCase(String city);

	List<DailyWeatherInfo> findByCityIgnoreCaseAndDate(String city, LocalDate today);

	List<DailyWeatherInfo> findByCityIgnoreCaseAndDateBetween(@Param("city") String city,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
