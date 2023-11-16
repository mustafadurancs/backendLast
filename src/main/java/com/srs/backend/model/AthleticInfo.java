package com.srs.backend.model;

import com.srs.backend.model.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "athleticinfos")
public class AthleticInfo extends Persistable {

    @Column(name = "height")
    public int height;

    @Column(name="weight")
    public double weight;

    @Column(name = "strength")
    public double strength;

    @Column(name = "speed")
    public double speed;

    @Column(name = "sat")
    public double sat;


    @Column(name = "starRtaing")
    public double starRating;


    @Column(name = "gpa")
    public double gpa;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSat() {
        return sat;
    }

    public void setSat(double sat) {
        this.sat = sat;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
