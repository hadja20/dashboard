package com.qpc.dashboard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RestController;

import com.qpc.dashboard.models.User;
import com.qpc.dashboard.service.UserService;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody User user){
        try{

            User user1=new User(user.getUsername(), user.getEmail(),passwordEncoder.encode(user.getPassword()));
            userService.addUser(user1);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    // ???
    // @PostMapping(value = "/register",consumes = "multipart/form-data", produces = "application/json")
    // public ResponseEntity<List<PlotDataDTO>> uploadData(
    //     @RequestPart("dataFile") @Valid @NotNull @NotBlank MultipartFile dataFile) throws IOException {
    //     fileProcessingService.processDTO(new DamFileDTO(dataFile));
    //    return fileProcessingService.getPlotData();
    // }
}
