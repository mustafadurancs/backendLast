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
    public String uuid;
    @Column
    public String username;
    @Column
    public String password;
    @Column
    public String name;
    @Column
    public String lastname;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    public Set<School> schools;


//    @JsonBackReference
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    public Set<Questionaire> questionaire;

//    @JsonBackReference
//    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user", fetch = FetchType.EAGER)
//    public List<School> schools = new ArrayList<>();

    @Column
    public String sport;  //football basboll
    @Column
    public String position;  //defence
    @Column
    public String tangables;  //
    @Column
    public String email;
    @Column
    public String phone;
    @Column
    public String address;
    @Column
    public String titter_handle;

    @Column
    public String instagram;

    @Column
    public String facebook;

    @Column
    public String snapchat;

    @Column
    public String aboutMe;

    @Column
    public String statistics;

    @Column
    public String seniorYear;


    @Column
    public String juniorYear;

    @Column
    public String accolades;

    @Column(name = "height")
    public String height;

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

    @Column(name = "verticalJump")
    public double verticalJump;

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


    @Column(name = "gpa")
    public double gpa;

    @Column(name = "act")
    public int act;

    @Column(name = "sat")
    public int sat;

    @Column(name = "transcript")
    public String transcript;

    @Column(name = "highLight")
    public String highLight;

    @Column(name = "validated")
    public boolean validated = false;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTangables(String tangables) {
        this.tangables = tangables;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTitter_handle(String titter_handle) {
        this.titter_handle = titter_handle;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public void setSeniorYear(String seniorYear) {
        this.seniorYear = seniorYear;
    }

    public void setJuniorYear(String juniorYear) {
        this.juniorYear = juniorYear;
    }

    public void setAccolades(String accolades) {
        this.accolades = accolades;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setForty(double forty) {
        this.forty = forty;
    }

    public void setFortyLazer(double fortyLazer) {
        this.fortyLazer = fortyLazer;
    }

    public void setProShuttle(double proShuttle) {
        this.proShuttle = proShuttle;
    }

    public void setVerticle(double verticle) {
        this.verticle = verticle;
    }

    public void setBroadJump(double broadJump) {
        this.broadJump = broadJump;
    }

    public void setBench(double bench) {
        this.bench = bench;
    }

    public void setSquat(double squat) {
        this.squat = squat;
    }

    public void setpClean(double pClean) {
        this.pClean = pClean;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public void setHighLight(String highLight) {
        this.highLight = highLight;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public double getVerticalJump() {
        return verticalJump;
    }

    public void setVerticalJump(double verticalJump) {
        this.verticalJump = verticalJump;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", schools=" + schools +
                ", sport='" + sport + '\'' +
                ", position='" + position + '\'' +
                ", tangables='" + tangables + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", titter_handle='" + titter_handle + '\'' +
                ", instagram='" + instagram + '\'' +
                ", facebook='" + facebook + '\'' +
                ", snapchat='" + snapchat + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", statistics='" + statistics + '\'' +
                ", seniorYear='" + seniorYear + '\'' +
                ", juniorYear='" + juniorYear + '\'' +
                ", accolades='" + accolades + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", forty=" + forty +
                ", fortyLazer=" + fortyLazer +
                ", proShuttle=" + proShuttle +
                ", verticle=" + verticle +
                ", broadJump=" + broadJump +
                ", bench=" + bench +
                ", squat=" + squat +
                ", pClean=" + pClean +
                ", strength=" + strength +
                ", speed=" + speed +
                ", gpa=" + gpa +
                ", act=" + act +
                ", sat=" + sat +
                ", transcript='" + transcript + '\'' +
                ", highLight='" + highLight + '\'' +
                ", validated=" + validated +
                '}';
    }
}