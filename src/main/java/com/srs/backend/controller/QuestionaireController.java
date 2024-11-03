package com.srs.backend.controller;

import com.srs.backend.model.Questionaire;
import com.srs.backend.service.QuestionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@RequestMapping("/questionaire/api")
public class QuestionaireController {

    @Autowired
    private QuestionaireService questionaireService;

    @PostMapping(value = "/save", consumes = {"application/json"})
    public ResponseEntity<Questionaire> addQuestionaire(@RequestBody Questionaire questionaire) {
        Questionaire addQuestionaire = questionaireService.addQuestionaire(questionaire);
        return new ResponseEntity<Questionaire>(addQuestionaire, HttpStatus.CREATED);
    }

    @PostMapping(value = "/payment-succeed", consumes = {"application/json"})
    public ResponseEntity addQuestionaire(@RequestParam("id") Long id, @RequestParam("price") Double price) {
        System.out.println(" _______________________________ called/payment-succeed   id:"+ id+" price: "+price);
            questionaireService.updatePaymentInfo(id,price);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Questionaire>> getAllQuestionaire() {
        List<Questionaire> allQuestionaire = questionaireService.findAllQuestionaire();
        return new ResponseEntity<List<Questionaire>>(allQuestionaire, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Questionaire> getQuestionaireById(@PathVariable("id") Long id) {
        Questionaire questionaire = questionaireService.getQuestionaireById(id);
        return new ResponseEntity<Questionaire>(questionaire, HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Questionaire>> getQuestionaireByUserId(@PathVariable("userId") Long userId) {
        List<Questionaire> questionaireList = questionaireService.findlQuestionaireByUserId(userId);
//        List<Long> idList = questionaireList.stream()
//                .map(Questionaire::getId).collect(Collectors.toList());
//        return new ResponseEntity<List<Long>>(idList, HttpStatus.OK);
        return new ResponseEntity<List<Questionaire>>(questionaireList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestionaireById(@PathVariable("id") Long id) {
        questionaireService.deleteQuestionaireById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
