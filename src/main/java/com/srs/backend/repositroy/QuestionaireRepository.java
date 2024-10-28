package com.srs.backend.repositroy;

import com.srs.backend.model.Questionaire;
import com.srs.backend.model.School;
import com.srs.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mustafa BILGIC
 * @created 29/11/2022
 * @project KARGO DROP
 */
public interface QuestionaireRepository extends JpaRepository<Questionaire,Long> {

   List<Questionaire> findAllByUserId(Long userId);
   @Transactional
   @Modifying
   @Query(value ="UPDATE Questionaire SET paid =true , price =:price WHERE id =:id", nativeQuery = true)
   void updatePaymentInfo(@Param("id")Long id,@Param("price") Double price);

   @Query(value = "SELECT * FROM School s WHERE s.GPA <=:gpa and s.SAT <=:sat  and s.ACT <=:act  " +
           "and s.hbcu =:hbcu  and s.type  IN (:type)  and s.region =:region and s.two_four_year =:schoolYear  and s.rating_level_min <=:ratingLevel and  s.rating_level_max >=:ratingLevel   order by s.score", nativeQuery = true)
   List<School> getSchoolsByParameters(@Param("gpa") double gpa, @Param("sat") int sat, @Param("act") int act, @Param("hbcu") String hbcu, @Param("type") List<String> type, @Param("region") String region, @Param("schoolYear") Integer schoolYear, Double ratingLevel);

}
