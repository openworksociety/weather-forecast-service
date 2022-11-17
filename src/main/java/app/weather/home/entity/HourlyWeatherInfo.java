package app.weather.home.entity;

import java.time.LocalDate;

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
@Table(name = "HOURLY_WEATHER_INFO")
public class HourlyWeatherInfo extends BasicWeatherInfoEntity {

	private static final long serialVersionUID = 7425121459537204850L;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "HOUR_COUNT")
	private Integer hourCount;
}
