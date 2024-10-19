package com.srs.backend.model;


import javax.persistence.*;


@Entity
@Table(name = "questionaire")
public class Questionaire extends Persistable {
//    @Column(name = "firstName")
//    public String firstName;
//
//    @Column(name = "lastName")
//    public String lastName;
//
//    @Column(name = "homeAddress")
//    public String homeAddress;
//
//    @Column(name = "city")
//    public String city;
//
//    @Column(name = "state")
//    public String state;
//
//    @Column(name = "zipCode")
//    public String zipCode;
//
//    @Column(name = "phoneNumber")
//    public String phoneNumber;
//
//    @Column(name = "email")
//    public String email;
//
//    @Column(name = "GPA")
//    public double GPA;
//
//    @Column(name = "SAT")
//    public int SAT;
//
//    @Column(name = "ACT")
//    public int ACT;
//
    @Column(name = "two_four_year")
    public int twoFourYear;

    @Column(name = "attendingHBCU")
    public boolean attendingHBCU;

    @Column(name = "startRatingBasedChart")
    public double startRatingBasedChart;

//    @Column(name = "ratingBasedChart")
//    public String ratingBasedChart;

//    @Column(name = "formDescription")
//    public String formDescription;
//
//    @Column(name = "generalInfo")
//    public String generalInfo;
//    @Column(name = "academicInfo")
//    public String academicInfo;

    @Column(name = "paid")
    public boolean paid;

    @Column(name = "type")
    public String type;
//
    @Column(name = "region")
    public String region;

    @Column(name = "notes")
    public String notes;

@ManyToOne
@JoinColumn(name = "user_id", nullable = true)
public Users user;

}
