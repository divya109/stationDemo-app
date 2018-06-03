package com.iheartradio.stationdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
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
	

}
