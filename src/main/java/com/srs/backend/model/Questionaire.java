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
    public int SAT;

    @Column(name = "ACT")
    public int ACT;

    @Column(name = "two_four_year")
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
    public boolean payed;

    @Column(name = "type")
    public String type;

    @Column(name = "region")
    public String region;

    @Column(name = "notes")
    public String notes;

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



    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getSAT() {
        return SAT;
    }



    public double getACT() {
        return ACT;
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

    public void setSAT(int SAT) {
        this.SAT = SAT;
    }

    public void setACT(int ACT) {
        this.ACT = ACT;
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
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
}
