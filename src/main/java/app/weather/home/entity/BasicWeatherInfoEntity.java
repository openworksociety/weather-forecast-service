package app.weather.home.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BasicWeatherInfoEntity extends BaseEntity {

	private static final long serialVersionUID = 5631640498338539909L;

	@Column(name = "TEMPERATURE")
	private Integer temperature;

	@Column(name = "WIND")
	private String wind;

	@Column(name = "HUMIDITY")
	private Integer humidity;

	@Column(name = "CITY")
	private String city;

}
