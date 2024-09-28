package com.srs.backend.repositroy;

import com.srs.backend.model.Questionaire;
import com.srs.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mustafa BILGIC
 * @created 29/11/2022
 * @project KARGO DROP
 */
public interface QuestionaireRepository extends JpaRepository<Questionaire,Long> {

   List<Questionaire> findAllByUserId(Long userId);

}
