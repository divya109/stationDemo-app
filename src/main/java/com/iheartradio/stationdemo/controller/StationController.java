package com.iheartradio.stationdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iheartradio.stationdemo.model.Station;
import com.iheartradio.stationdemo.repository.StationRepository;

@RestController
public class StationController {

@Autowired
StationRepository stationRepository;
	
@GetMapping(path="/stations/list")
public Iterable<Station> getAllStations(){	
	return stationRepository.findAll();
}

/*@GetMapping(path="/stations/{id}")
public Optional<Station> getStation(@RequestParam Long id){
	 
	if(stationRepository.findById(id).isPresent()){
		return stationRepository.findById(id);
	}
	else return null;
}*/
	
}
