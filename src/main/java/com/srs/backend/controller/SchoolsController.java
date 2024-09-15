package com.srs.backend.controller;

import com.srs.backend.model.School;
import com.srs.backend.service.SchoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/school/api")
public class SchoolsController {

    @Autowired
    private SchoolsService schoolService;
    ;

    @PostMapping("/save")
    public ResponseEntity<School> addCustomer(@RequestBody School schools) {
        School addSchool = schoolService.saveSchools(schools);
        return new ResponseEntity<School>(addSchool, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<School>> getAllCustomer() {
        List<School> allSchool = schoolService.findAllSchool();
        return new ResponseEntity<List<School>>(allSchool, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<School> getCustomerId(@PathVariable("id") Long id) {
        School schools = schoolService.getSchoolById(id);
        return new ResponseEntity<School>(schools, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/schoolsByParameters")
    public ResponseEntity<List<School>> getSchoolsByParameters(@RequestParam("gpa") Double gpa, @RequestParam("sat") Integer sat, @RequestParam("act") Integer act, @RequestParam("hbcu") String hbcu,@RequestParam("type") String type,@RequestParam("region") String region , @RequestParam("year") Integer year, @RequestParam("ratingLevel") Double ratingLevel) {

        List<School> schoolsByParameters = schoolService.getSchoolsByParameters(gpa, sat, act, hbcu,type, region, year,ratingLevel);
        return new ResponseEntity<List<School>>(schoolsByParameters, HttpStatus.OK);
    }


}
