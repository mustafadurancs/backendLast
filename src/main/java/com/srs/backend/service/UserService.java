package com.srs.backend.service;

import com.srs.backend.model.Users;
import com.srs.backend.repositroy.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;


@Service
public class UserService {
    private static final Logger log = getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public Users addUser(Users users) {
        return userRepository.save(users);
    }


    public boolean validateUser(String username) {
        Users user = userRepository.findFirstByUsername(username);
        if (user != null) {
            user.validated = Boolean.TRUE;
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Boolean updatePassword(String uuid, String password) {
        log.info("updatePassword  initialize method called. uuid: {} password:{}", uuid,   password);

        Users user = userRepository.findFirstByUuid(uuid);
        log.info("updatePassword  initialize method called. {}",user);

        if (user != null) {
            log.info("inside updatePassword ");
            user.setPassword(password);
            userRepository.save(user);
            return true;
        } else {
            log.info("there is no user !!!!!!");
            return false;
        }
    }


    public Users updateUser(Users users) {
        Optional<Users> localUser = userRepository.findById(users.getId());


        localUser.get().setName(users.name);
        localUser.get().setLastname(users.lastname);
        localUser.get().setSport(users.sport);
        localUser.get().setPosition(users.position);
        localUser.get().setTangables(users.tangables);
        localUser.get().setEmail(users.email);
        localUser.get().setPhone(users.phone);
        localUser.get().setAddress(users.address);
        localUser.get().setTitter_handle(users.titter_handle);
        localUser.get().setInstagram(users.instagram);
        localUser.get().setFacebook(users.facebook);
        localUser.get().setSnapchat(users.snapchat);
        localUser.get().setAboutMe(users.aboutMe);
        localUser.get().setStatistics(users.statistics);
        localUser.get().setSeniorYear(users.seniorYear);
        localUser.get().setJuniorYear(users.juniorYear);
        localUser.get().setAccolades(users.accolades);
        localUser.get().setHeight(users.height);
        localUser.get().setWeight(users.weight);
        localUser.get().setForty(users.forty);
        localUser.get().setFortyLazer(users.fortyLazer);
        localUser.get().setProShuttle(users.proShuttle);
        localUser.get().setVerticle(users.verticle);
        localUser.get().setBroadJump(users.broadJump);
        localUser.get().setBench(users.bench);
        localUser.get().setSquat(users.squat);
        localUser.get().setpClean(users.pClean);
        localUser.get().setStrength(users.strength);
        localUser.get().setSpeed(users.speed);



        localUser.get().setGpa(users.gpa);
        localUser.get().setAct(users.act);
        localUser.get().setSat(users.sat);
        localUser.get().setTranscript(users.transcript);
        localUser.get().setHighLight(users.highLight);


        return userRepository.save(localUser.get());
    }

    public Optional<Users> findlUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<Users> findAllUser() {
        return userRepository.findAll();
    }

    public Users getUserByUserNameAndPassword(String username, String password) {
        Users user = null;
        if (!password.isEmpty())
            user = userRepository.findFirstByUsernameAndPasswordAndValidatedIsTrue(username, password);
        else {
            user = userRepository.findFirstByUsername(username);
        }
        return user;
    }


    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
