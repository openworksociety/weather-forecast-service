package app.weather.home.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DAILY_WEATHER_INFO")
public class DailyWeatherInfo extends BasicWeatherInfoEntity {

	private static final long serialVersionUID = 2351535494455423506L;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "SUNRISE_TIME")
	private LocalTime sunriseTime;

	@Column(name = "SUNSET_TIME")
	private LocalTime sunsetTime;

}
