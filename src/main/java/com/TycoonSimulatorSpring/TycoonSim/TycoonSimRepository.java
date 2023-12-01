package com.TycoonSimulatorSpring.TycoonSim;

import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;


public interface TycoonSimRepository extends DatastoreRepository<TycoonSimApplication, Long> {

    List<TycoonSimApplication> findByName(String name);

    List<TycoonSimApplication> findByScore(int score);

    List<TycoonSimApplication> findByHighScore();

}