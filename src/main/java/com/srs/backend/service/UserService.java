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


        localUser.get().setName(users.getName());
        localUser.get().setLastname(users.getLastname());
        localUser.get().setSport(users.getSport());
        localUser.get().setPosition(users.getPosition());
        localUser.get().setTangables(users.getTangables());
        localUser.get().setEmail(users.getEmail());
        localUser.get().setPhone(users.getPhone());
        localUser.get().setAddress(users.getAddress());
        localUser.get().setTitter_handle(users.getTitter_handle());
        localUser.get().setInstagram(users.getInstagram());
        localUser.get().setFacebook(users.getFacebook());
        localUser.get().setSnapchat(users.getSnapchat());
        localUser.get().setAboutMe(users.getAboutMe());
        localUser.get().setStatistics(users.getStatistics());
        localUser.get().setSeniorYear(users.getSeniorYear());
        localUser.get().setJuniorYear(users.getJuniorYear());
        localUser.get().setAccolades(users.getAccolades());
        localUser.get().setHeight(users.getHeight());
        localUser.get().setWeight(users.getWeight());
        localUser.get().setForty(users.getForty());
        localUser.get().setFortyLazer(users.getFortyLazer());
        localUser.get().setProShuttle(users.getProShuttle());
        localUser.get().setVerticle(users.getVerticle());
        localUser.get().setBroadJump(users.getBroadJump());
        localUser.get().setBench(users.getBench());
        localUser.get().setSquat(users.getSquat());
        localUser.get().setpClean(users.getpClean());
        localUser.get().setStrength(users.getStrength());
        localUser.get().setSpeed(users.getSpeed());



        localUser.get().setGpa(users.getGpa());
        localUser.get().setAct(users.getAct());
        localUser.get().setSat(users.getSat());
        localUser.get().setTranscript(users.getTranscript());
        localUser.get().setHighLight(users.getHighLight());


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
