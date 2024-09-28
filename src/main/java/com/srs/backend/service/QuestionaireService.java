package com.srs.backend.service;


import com.srs.backend.model.Questionaire;
import com.srs.backend.repositroy.QuestionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionaireService {

    @Autowired
    private QuestionaireRepository questionaireRepository;

    public Questionaire addQuestionaire(Questionaire questionaire) {
        return questionaireRepository.save(questionaire);
    }

    public List<Questionaire> findAllQuestionaire() {
        return questionaireRepository.findAll();
    }

    public Questionaire getQuestionaireById(Long questionaireInfoIdId) {

        Optional<Questionaire> questionaireOption = questionaireRepository.findById(questionaireInfoIdId);
        if (questionaireOption.isPresent()) {
            return questionaireOption.get();
        }
        return null;

    }

    public void deleteQuestionaireById(Long athleticInfoId) {
        questionaireRepository.deleteById(athleticInfoId);
    }

    public Optional<Questionaire> findlQuestionaireById(Long id) {
        return questionaireRepository.findById(id);
    }


    public List<Questionaire> findlQuestionaireByUserId(Long userId) {
        return questionaireRepository.findAllByUserId(userId);
    }
}
