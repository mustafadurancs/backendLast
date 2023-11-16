package com.srs.backend.model;

import javax.persistence.*;

/**
 * @author Mustafa BILGIC
 * @created 23/12/2022
 * @project KARGO DROPh
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
    @Column(name = "region")
    public String region;
    @Column(name = "type")
    public String type;
    @Column(name = "hbcu")
    public String hbcu;
    @Column(name = "conference")
    public String conference;

    @Column(name = "divisionOne")
    public String divisionOne;

    @Column(name = "divisionTwo")
    public String divisionTwo;

    @Column(name = "twoFourYear")
    public String twoFourYear;
    @Column(name = "schoolWebsite")
    public String schoolWebsite;
    @Column(name = "athleticWebsite")
    public String athleticWebsite;
    @Column(name = "nicheWebsite")
    public String nicheWebsite;
    @Column(name = "ACTRangeMin")
    public Integer ACTRangeMin;
    @Column(name = "ACTRangeMax")
    public Integer ACTRangeMax;
    @Column(name = "SATRangeMin")
    public Integer SATRangeMin;
    @Column(name = "SATRangeMax")
    public Integer SATRangeMax;
    @Column(name = "GPA")
    public Double GPA;



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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHbcu() {
        return hbcu;
    }

    public void setHbcu(String hbcu) {
        this.hbcu = hbcu;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivisionOne() {
        return divisionOne;
    }

    public void setDivisionOne(String divisionOne) {
        this.divisionOne = divisionOne;
    }

    public String getDivisionTwo() {
        return divisionTwo;
    }

    public void setDivisionTwo(String divisionTwo) {
        this.divisionTwo = divisionTwo;
    }

    public String getTwoFourYear() {
        return twoFourYear;
    }

    public void setTwoFourYear(String twoFourYear) {
        this.twoFourYear = twoFourYear;
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

    public String getNicheWebsite() {
        return nicheWebsite;
    }

    public void setNicheWebsite(String nicheWebsite) {
        this.nicheWebsite = nicheWebsite;
    }

    public Integer getACTRangeMin() {
        return ACTRangeMin;
    }

    public void setACTRangeMin(Integer ACTRangeMin) {
        this.ACTRangeMin = ACTRangeMin;
    }

    public Integer getACTRangeMax() {
        return ACTRangeMax;
    }

    public void setACTRangeMax(Integer ACTRangeMax) {
        this.ACTRangeMax = ACTRangeMax;
    }

    public Integer getSATRangeMin() {
        return SATRangeMin;
    }

    public void setSATRangeMin(Integer SATRangeMin) {
        this.SATRangeMin = SATRangeMin;
    }

    public Integer getSATRangeMax() {
        return SATRangeMax;
    }

    public void setSATRangeMax(Integer SATRangeMax) {
        this.SATRangeMax = SATRangeMax;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "School{" +
                "id='" + super.getId() + '\'' +
                "school='" + school + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", region='" + region + '\'' +
                ", type='" + type + '\'' +
                ", hbcu='" + hbcu + '\'' +
                ", conference='" + conference + '\'' +
                ", divisionOne='" + divisionOne + '\'' +
                ", divisionTwo='" + divisionTwo + '\'' +
                ", twoFourYear='" + twoFourYear + '\'' +
                ", schoolWebsite='" + schoolWebsite + '\'' +
                ", athleticWebsite='" + athleticWebsite + '\'' +
                ", nicheWebsite='" + nicheWebsite + '\'' +
                ", ACTRangeMin=" + ACTRangeMin +
                ", ACTRangeMax=" + ACTRangeMax +
                ", SATRangeMin=" + SATRangeMin +
                ", SATRangeMax=" + SATRangeMax +
                ", GPA='" + GPA + '\'' +
                ", score=" + score +
                ", user=" + user +
                '}';
    }
}



