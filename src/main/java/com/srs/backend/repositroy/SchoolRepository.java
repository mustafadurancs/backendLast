package com.srs.backend.repositroy;

import com.srs.backend.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SchoolRepository extends JpaRepository<School, Long> {
    School findFirstById(Long schoolId);


    @Query(value = "SELECT * FROM School s WHERE s.GPA <=:gpa and  s.SAT <=:sat and  s.SAT >=:sat and s.ACT <=:act and  s.ACT >=:act and s.hbcu =:hbcu and s.type =:type and s.two_four_year LIKE %:schoolYear%  order by s.score", nativeQuery = true)
    List<School> getSchoolsByParameters(@Param("gpa") double gpa, @Param("sat") double sat, @Param("act") double act, @Param("hbcu") String hbcu, @Param("type") String type, @Param("schoolYear") Integer schoolYear);


    List<School> getSchoolsByTwoFourYearContaining(Integer schoolYear);

}
