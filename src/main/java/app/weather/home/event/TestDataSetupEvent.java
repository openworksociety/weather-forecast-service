package app.weather.home.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import app.weather.home.entity.LocationInfo;
import app.weather.home.repository.LocationInfoRepository;

@Component
public class TestDataSetupEvent implements ApplicationListener<ContextRefreshedEvent> {

	boolean isSaved = false;

	@Autowired
	private LocationInfoRepository locationInfoRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (isSaved) {
			return;
		}

		locationInfoRepository.save(LocationInfo.builder().city("Hamburg").country("Germany").latitude(53.551086)
				.longitude(9.993682).build());
		locationInfoRepository.save(
				LocationInfo.builder().city("Latur").country("India").latitude(50.551086).longitude(8.993682).build());

		isSaved = true;
	}

}
