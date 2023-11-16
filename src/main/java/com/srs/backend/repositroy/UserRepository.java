package com.srs.backend.repositroy;

import com.srs.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Long> {
    Users findFirstByUsernameAndPassword(String username, String pass);

    Users findFirstByUsername(String username);

    Boolean deleteByUsername(String username);


}
