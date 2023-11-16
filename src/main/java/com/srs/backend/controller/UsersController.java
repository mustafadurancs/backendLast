package com.srs.backend.controller;


import com.srs.backend.SRSUtil;
import com.srs.backend.model.School;
import com.srs.backend.model.Users;
import com.srs.backend.service.SchoolsService;
import com.srs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/user/api")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolsService schoolService;

    @GetMapping("/message")
    public String getMessage() {
        return "it OK.";
    }

    @PostMapping("/save")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users userObject = userService.addUser(user);
        return new ResponseEntity<Users>(userObject, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        Users userObject = userService.updateUser(user);
        return new ResponseEntity<Users>(userObject, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> users = userService.findAllUser();
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    @GetMapping("/bid")
    public ResponseEntity<Users> getUserId(@RequestBody Users user) {
        Users userObject = userService.getUserByUserNameAndPassword(user.getUsername(), user.getPassword());
        return new ResponseEntity<Users>(userObject, HttpStatus.OK);
    }


    @GetMapping("/id")
    public ResponseEntity<Users> getUserId(@RequestParam("username") String username, @RequestParam("password") String password) {
        Users userObject = userService.getUserByUserNameAndPassword(username, password);
        if (userObject == null) userObject = new Users();
        return new ResponseEntity<Users>(userObject, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUserByUsername(@RequestBody Users user) {
        userService.deleteUserByUsername(user.getUsername());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }


//     @RequestMapping(value = "/getpdf", method = RequestMethod.POST)
    @RequestMapping(value = "/getpdf", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<byte[]> getPDF(@RequestParam("userId") Long userId) {

        Optional<Users> optionalUserId = userService.findlUserById(userId);
        byte[] contents = new byte[999999999];
        if (optionalUserId.isPresent()) {
            Users user = optionalUserId.get();
            List<School> schoolsByParameters = schoolService.getSchoolsByParameters(user.gpa, user.sat, user.act, "", "Private", 1, 4);
            contents = SRSUtil.createPDF(user, schoolsByParameters);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Here you have to set the actual filename of your pdf
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }
}
