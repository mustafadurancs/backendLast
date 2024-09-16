package com.srs.backend.model;

import javax.persistence.*;

/**
 * @author Mustafa BILGIC
 * @created 23/12/2022
 * @project
 */
@Entity
@Table(name = "School")
public class School extends Persistable {

    @Column(name = "school")
    public String school;
    @Column(name = "city")
    public String city;
    @Column(name = "state")
    public String state;

    @Column(name = "two_four_year")
    public Integer twoFourYear;
    @Column(name = "hbcu")
    public String hbcu;

    @Column(name = "type")
    public String type;

    @Column(name = "region")
    public String region;


    @Column(name = "rating_level_min")
    public double ratingLevelMin;


    @Column(name = "rating_level_max")
    public double ratingLevelMax;

    @Column(name = "division")
    public String division;

    @Column(name = "conference_abbreviation")
    public String conferenceAbbreviation;



    @Column(name = "school_website")
    public String schoolWebsite;
    @Column(name = "athletic_website")
    public String athleticWebsite;


    @Column(name = "GPA")
    public Double GPA;
    @Column(name = "SAT")
    public Integer SAT;
    @Column(name = "ACT")
    public Integer ACT;


    @Column(name = "score")
    public Double score;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    public Users user;


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTwoFourYear() {
        return twoFourYear;
    }

    public void setTwoFourYear(Integer twoFourYear) {
        this.twoFourYear = twoFourYear;
    }

    public String getHbcu() {
        return hbcu;
    }

    public void setHbcu(String hbcu) {
        this.hbcu = hbcu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getRatingLevelMin() {
        return ratingLevelMin;
    }

    public void setRatingLevelMin(double ratingLevelMin) {
        this.ratingLevelMin = ratingLevelMin;
    }

    public double getRatingLevelMax() {
        return ratingLevelMax;
    }

    public void setRatingLevelMax(double ratingLevelMax) {
        this.ratingLevelMax = ratingLevelMax;
    }



    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getConferenceAbbreviation() {
        return conferenceAbbreviation;
    }

    public void setConferenceAbbreviation(String conferenceAbbreviation) {
        this.conferenceAbbreviation = conferenceAbbreviation;
    }

    public String getSchoolWebsite() {
        return schoolWebsite;
    }

    public void setSchoolWebsite(String schoolWebsite) {
        this.schoolWebsite = schoolWebsite;
    }

    public String getAthleticWebsite() {
        return athleticWebsite;
    }

    public void setAthleticWebsite(String athleticWebsite) {
        this.athleticWebsite = athleticWebsite;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public Integer getSAT() {
        return SAT;
    }

    public void setSAT(Integer SAT) {
        this.SAT = SAT;
    }

    public Integer getACT() {
        return ACT;
    }

    public void setACT(Integer ACT) {
        this.ACT = ACT;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}



