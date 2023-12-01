package com.TycoonSimulatorSpring.TycoonSim;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity(name = "TycoonSim")
public class TycoonSim {
    @Id
    private Long id;

    private String name;
    private Date date;
    private int score;

    public TycoonSim(String name, Date date, int score) {
        this.name = name;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", score=" + score +
                '}';
    }
}
