package com.srs.backend.service;

import com.srs.backend.model.AthleticInfo;
import com.srs.backend.repositroy.AthleticInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AthleticInfoService {

    @Autowired
    private AthleticInfoRepository athleticInfoRepository;

    public AthleticInfo saveAthleticInfo(AthleticInfo athleticInfo) {
        return athleticInfoRepository.save(athleticInfo);
    }

    public List<AthleticInfo> findAllAthleticInfo() {
        return athleticInfoRepository.findAll();
    }

    public AthleticInfo getAthleticInfoById(Long athleticInfoIdId) {
        return athleticInfoRepository.findById(athleticInfoIdId).get();
    }

    public void deleteAthleticInfoById(Long athleticInfoId) {
        athleticInfoRepository.deleteById(athleticInfoId);
    }
}
