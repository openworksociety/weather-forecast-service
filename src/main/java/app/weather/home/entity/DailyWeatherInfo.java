package app.weather.home.entity;

import java.util.Date;

import javax.persistence.Column;

public class DailyWeatherInfo extends BasicWeatherInfoEntity{

	private static final long serialVersionUID = 2351535494455423506L;
	
	@Column(name = "SUNRISE_TIME")
	private Date sunriseTime;
	
	@Column(name = "SUNSET_TIME")
	private Date sunsetTime;

}
