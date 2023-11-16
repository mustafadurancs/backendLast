package com.srs.backend.repositroy;

import com.srs.backend.model.Questionaire;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mustafa BILGIC
 * @created 29/11/2022
 * @project KARGO DROP
 */
public interface QuestionaireRepository extends JpaRepository<Questionaire,Long> {
}
