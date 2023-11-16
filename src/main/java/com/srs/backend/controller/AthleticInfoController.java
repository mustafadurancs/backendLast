package com.srs.backend.controller;

import com.srs.backend.model.AthleticInfo;
import com.srs.backend.service.AthleticInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/athleticInfo/api")
public class AthleticInfoController {

    @Autowired
    private AthleticInfoService athleticInfoService;;

    @PostMapping("/save")
    public ResponseEntity<AthleticInfo> addCustomer(@RequestBody AthleticInfo customer) {
        AthleticInfo addAthleticInfo = athleticInfoService.saveAthleticInfo(customer);
        return new ResponseEntity<AthleticInfo>(addAthleticInfo, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AthleticInfo>> getAllCustomer() {
        List<AthleticInfo> allAthleticInfo = athleticInfoService.findAllAthleticInfo();
        return new ResponseEntity<List<AthleticInfo>>(allAthleticInfo, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AthleticInfo> getCustomerId(@PathVariable("id") Long id) {
        AthleticInfo athleticInfoId = athleticInfoService.getAthleticInfoById(id);
        return new ResponseEntity<AthleticInfo>(athleticInfoId, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
        athleticInfoService.deleteAthleticInfoById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
