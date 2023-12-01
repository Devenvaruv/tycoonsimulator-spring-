package com.TycoonSimulatorSpring.TycoonSim;

import java.util.List;

import com.google.common.collect.Lists;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
public class TycoonSimApplication {
	@Autowired
	TycoonSimRepository tycoonSimRepository;

	public static void main(String[] args) {
		SpringApplication.run(TycoonSimApplication.class, args);
	}

	@ShellMethod("Saves a Sim to Cloud Datastore: save-Sim <name> <date> <score>")
	public String saveSim(String name, Date date, int score) {
		TycoonSim savedSim = this.tycoonSimRepository.save(new TycoonSim(name, date, score));
		return savedSim.toString();
	}

	@ShellMethod("Loads all sims")
	public String findAllSims() {
		Iterable<TycoonSim> sims = this.tycoonSimRepository.findAll();
		return Lists.newArrayList(sims).toString();
	}

	@ShellMethod("Loads sims by name: find-by-name <name>")
	public String findByName(String name) {
		List<TycoonSim> sims = this.tycoonSimRepository.findByName(name);
		return sims.toString();
	}

	@ShellMethod("Loads sims published by a score: find-by-score <score>")
	public String findByScore(int score) {
		List<TycoonSim> sims = this.tycoonSimRepository.findByScore(score);
		return sims.toString();
	}

	@ShellMethod("Loads books by author and year: find-by-author-year <author> <year>")
	public String findByHighScore() {
		List<TycoonSim> sims = this.tycoonSimRepository.findByHighScore();
		return sims.toString();
	}

	@ShellMethod("Removes all sims")
	public void removeAllSims() {
		this.tycoonSimRepository.deleteAll();
	}
}