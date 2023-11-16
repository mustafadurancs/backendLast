package com.srs.backend.service;

import com.srs.backend.model.School;
import com.srs.backend.repositroy.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SchoolsService {

    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School schools) {
        return schoolRepository.save(schools);
    }

    public School saveSchools(School schools) {
        return schoolRepository.save(schools);
    }

    public List<School> findAllSchool() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long schoolId) {
        School schools = schoolRepository.findFirstById(schoolId);
        return schools;
    }

    public List<School> getSchoolsByParameters(double gpa, double sat, double act, String hbcu, String type, Integer starRate, Integer year) {
        List<School> schools;


        int range1 = 0, range2 = 30;

        if (starRate != null && (starRate == 3)) {
            range1 = 10;
            range2 = 40;
        } else if (starRate != null && (starRate == 2)) {
            range1 = 20;
            range2 = 50;
        } else if (starRate != null && (starRate == 1)) {
            range1 = 30;
            range2 = 60;
        }


        if (year == 4) {
            schools = schoolRepository.getSchoolsByParameters(gpa, sat, act, (hbcu!=null && hbcu.equals("BOTH") ) ? "" : hbcu, type, year);

        } else {
            schools = schoolRepository.getSchoolsByTwoFourYearContaining(year);
            if (schools.size() > 29) {
                return schools.subList(0, 30);
            }
        }
        return schools;
    }

    public void deleteSchoolById(Long schoolId) {
        schoolRepository.deleteById(schoolId);
    }
}
