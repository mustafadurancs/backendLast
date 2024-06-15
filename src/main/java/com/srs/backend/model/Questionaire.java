package com.srs.backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "questionaire")
public class Questionaire extends Persistable {
    @Column(name = "firstName")
    public String firstName;

    @Column(name = "lastName")
    public String lastName;

    @Column(name = "homeAddress")
    public String homeAddress;

    @Column(name = "city")
    public String city;

    @Column(name = "state")
    public String state;

    @Column(name = "zipCode")
    public String zipCode;

    @Column(name = "phoneNumber")
    public String phoneNumber;

    @Column(name = "email")
    public String email;

    @Column(name = "GPA")
    public double GPA;

    @Column(name = "SAT")
    public double SAT;

    @Column(name = "ACT")
    public double ACT;

    @Column(name = "twoFourYear")
    public double twoFourYear;

    @Column(name = "attendingHBCU")
    public boolean attendingHBCU;

    @Column(name = "startRatingBasedChart")
    public String startRatingBasedChart;









    //    @Column(name = "ratingBasedChart")
//    public String ratingBasedChart;

//    @Column(name = "formDescription")
//    public String formDescription;
//
//    @Column(name = "generalInfo")
//    public String generalInfo;
//    @Column(name = "academicInfo")
//    public String academicInfo;


    
    @Column(name = "payed")
    public Boolean payed;

//    public String getFormDescription() {
//        return formDescription;
//    }
//
//    public void setFormDescription(String formDescription) {
//        this.formDescription = formDescription;
//    }
//
//    public String getGeneralInfo() {
//        return generalInfo;
//    }
//
//    public void setGeneralInfo(String generalInfo) {
//        this.generalInfo = generalInfo;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getAcademicInfo() {
//        return academicInfo;
//    }
//
//    public void setAcademicInfo(String academicInfo) {
//        this.academicInfo = academicInfo;
//    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public double getSAT() {
        return SAT;
    }

    public void setSAT(double SAT) {
        this.SAT = SAT;
    }

    public double getACT() {
        return ACT;
    }

    public void setACT(double ACT) {
        this.ACT = ACT;
    }

    public double getTwoFourYear() {
        return twoFourYear;
    }

    public void setTwoFourYear(double twoFourYear) {
        this.twoFourYear = twoFourYear;
    }

    public String getStartRatingBasedChart() {
        return startRatingBasedChart;
    }

    public void setStartRatingBasedChart(String startRatingBasedChart) {
        this.startRatingBasedChart = startRatingBasedChart;
    }

//    public String getRatingBasedChart() {
//        return ratingBasedChart;
//    }
//
//    public void setRatingBasedChart(String ratingBasedChart) {
//        this.ratingBasedChart = ratingBasedChart;
//    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }
}
