package com.srs.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users extends Persistable {



    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String lastname;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<School> schools;
//    @JsonBackReference
//    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user", fetch = FetchType.EAGER)
//    private List<School> schools = new ArrayList<>();

    @Column
    private String sport;
    @Column
    private String position;
    @Column
    private String tangables;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String titter_handle;

    @Column
    private String instagram;

    @Column
    private String facebook;

    @Column
    private String snapchat;

    @Column
    private String aboutMe;

    @Column
    private String statistics;

    @Column
    private String seniorYear;


    @Column
    private String juniorYear;

    @Column
    private String accolades;

    @Column(name = "height")
    public int height;

    @Column(name = "weight")
    public double weight;


    @Column(name = "forty")
    public double forty;

    @Column(name = "fortyLazer")
    public double fortyLazer;

    @Column(name = "proShuttle")
    public double proShuttle;

    @Column(name = "verticle")
    public double verticle;

    @Column(name = "broadJump")
    public double broadJump;

    @Column(name = "bench")
    public double bench;

    @Column(name = "squat")
    public double squat;

    @Column(name = "pClean")
    public double pClean;

    @Column(name = "strength")
    public double strength;

    @Column(name = "speed")
    public double speed;

    @Column(name = "starRtaing")
    public double starRating;

    @Column(name = "gpa")
    public double gpa;

    @Column(name = "act")
    public double act;

    @Column(name = "sat")
    public double sat;

    @Column(name = "transcript")
    public String transcript;

    @Column(name = "highLight")
    public String highLight;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }


//    public List<School> getSchools() {
//        return schools;
//    }
//
//    public void setSchools(List<School> schools) {
//        this.schools = schools;
//    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTangables() {
        return tangables;
    }

    public void setTangables(String tangables) {
        this.tangables = tangables;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitter_handle() {
        return titter_handle;
    }

    public void setTitter_handle(String titter_handle) {
        this.titter_handle = titter_handle;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public String getSeniorYear() {
        return seniorYear;
    }

    public void setSeniorYear(String seniorYear) {
        this.seniorYear = seniorYear;
    }

    public String getJuniorYear() {
        return juniorYear;
    }

    public void setJuniorYear(String juniorYear) {
        this.juniorYear = juniorYear;
    }

    public String getAccolades() {
        return accolades;
    }

    public void setAccolades(String accolades) {
        this.accolades = accolades;
    }

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

    public double getForty() {
        return forty;
    }

    public void setForty(double forty) {
        this.forty = forty;
    }

    public double getFortyLazer() {
        return fortyLazer;
    }

    public void setFortyLazer(double fortyLazer) {
        this.fortyLazer = fortyLazer;
    }

    public double getProShuttle() {
        return proShuttle;
    }

    public void setProShuttle(double proShuttle) {
        this.proShuttle = proShuttle;
    }

    public double getVerticle() {
        return verticle;
    }

    public void setVerticle(double verticle) {
        this.verticle = verticle;
    }

    public double getBroadJump() {
        return broadJump;
    }

    public void setBroadJump(double broadJump) {
        this.broadJump = broadJump;
    }

    public double getBench() {
        return bench;
    }

    public void setBench(double bench) {
        this.bench = bench;
    }

    public double getSquat() {
        return squat;
    }

    public void setSquat(double squat) {
        this.squat = squat;
    }

    public double getpClean() {
        return pClean;
    }

    public void setpClean(double pClean) {
        this.pClean = pClean;
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

    public double getAct() {
        return act;
    }

    public void setAct(double act) {
        this.act = act;
    }

    public double getSat() {
        return sat;
    }

    public void setSat(double sat) {
        this.sat = sat;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public String getHighLight() {
        return highLight;
    }

    public void setHighLight(String highLight) {
        this.highLight = highLight;
    }
}