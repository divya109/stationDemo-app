package com.iheartradio.stationdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.iheartradio.stationdemo.model.Station;

public interface StationRepository extends CrudRepository<Station, Long> {

	Station findByName(String name);
}
