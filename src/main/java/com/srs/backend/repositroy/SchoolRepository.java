package com.srs.backend.repositroy;

import com.srs.backend.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SchoolRepository extends JpaRepository<School, Long> {
    School findFirstById(Long schoolId);


    /**
     *  todo will be update
     *  two four year 2-4
     *  hbcu  yes no
     *  type private public all
     * region string value
     *  rating min max  atri eksi %0.5 deger gelicek
     *  gpa
     *
     *
     * @param gpa
     * @param sat
     * @param act
     * @param hbcu
     * @param type
     * @param schoolYear
     * @return
     */

    @Query(value = "SELECT * FROM School s WHERE s.GPA <=:gpa and  s.SAT <=:sat and  s.SAT >=:sat and s.ACT <=:act and  s.ACT >=:act " +
                                                "and s.hbcu IN (:hbcu) and s.type =:type  and s.region =:region and s.two_four_year LIKE %:schoolYear%  and s.ratingLevelMin <=:ratingLevel and  s.ratingLevelMax >=:ratingLevel   order by s.score", nativeQuery = true)
    List<School> getSchoolsByParameters(@Param("gpa") double gpa, @Param("sat") int sat, @Param("act") int act, @Param("hbcu") List<String> hbcu, @Param("type") String type,@Param("region") String region, @Param("schoolYear") Integer schoolYear,Double ratingLevel);


    List<School> getSchoolsByTwoFourYearContaining(Integer schoolYear);

}
