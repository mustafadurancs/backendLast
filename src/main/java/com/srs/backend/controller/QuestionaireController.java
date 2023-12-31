package com.srs.backend.controller;

import com.srs.backend.model.Questionaire;
import com.srs.backend.service.QuestionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/questionaire/api")
public class QuestionaireController {

    @Autowired
    private QuestionaireService questionaireService;

    @PostMapping("/save")
    public ResponseEntity<Questionaire> addQuestionaire(@RequestBody Questionaire questionaire) {
        Questionaire addQuestionaire = questionaireService.addQuestionaire(questionaire);
        return new ResponseEntity<Questionaire>(addQuestionaire, HttpStatus.CREATED);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestionaireById(@PathVariable("id") Long id) {
        questionaireService.deleteQuestionaireById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
