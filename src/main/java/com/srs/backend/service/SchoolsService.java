package com.srs.backend.service;

import com.srs.backend.SchoolTypeEnums;
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


    public List<School> getSchoolsByParameters(double gpa,int sat,int act, String hbcu, String type,String region,  Integer year,double ratingLevel) {
        List schools;
        List hbcuParamList = new ArrayList();
        if (hbcu != null && hbcu.equals("ALL")) {
            hbcuParamList.add(SchoolTypeEnums.Private.name());
            hbcuParamList.add(SchoolTypeEnums.Public.name());
        } else {
            hbcuParamList.add(hbcu);
        }

        if (year == 4) {
            schools = schoolRepository.getSchoolsByParameters(gpa, sat, act, hbcuParamList, type, region,year,ratingLevel);
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
