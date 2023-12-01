package com.TycoonSimulatorSpring.TycoonSim;

import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;


public interface TycoonSimRepository extends DatastoreRepository<TycoonSim, Long> {

    List<TycoonSim> findByName(String name);

    List<TycoonSim> findByScore(int score);

    List<TycoonSim> findByHighScore();

}