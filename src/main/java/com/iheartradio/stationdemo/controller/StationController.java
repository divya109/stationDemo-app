package com.iheartradio.stationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@GetMapping(path="/stations/{id}")
public Station getStation(@PathVariable("id") Long id){	 
	if(stationRepository.findById(id).isPresent()){
		return stationRepository.findById(id).get();
	}
	else return null;
}
	
}
