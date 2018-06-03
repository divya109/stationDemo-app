package com.iheartradio.stationdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.iheartradio.stationdemo.model.Station;
import com.iheartradio.stationdemo.repository.StationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class StationdemoApplicationTests {

	@Autowired
	StationRepository stationRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void whenFindStationByName_thenReturnStation(){
		String testName = "testStation";
	    entityManager.persist(new Station(testName,"FM","testing"));
		Station station = stationRepository.findByName(testName);
		assertThat(testName).isEqualTo(station.getName());
	}
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() {
		String stationURL = "http://localhost:8080/stations/101";
		String expectedStationName = "KISSFM";
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<Station> response = restTemplate.exchange(stationURL,HttpMethod.GET,entity, Station.class);
		assertThat(expectedStationName).isEqualTo(response.getBody().getName());
	}
}
