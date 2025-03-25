package com.qpc.dashboard.controller;

import com.qpc.dashboard.models.LoginRequest;
import com.qpc.dashboard.models.LoginResponse;
import com.qpc.dashboard.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {


    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    // @CrossOrigin(origins = "http://localhost:8080")
    // @PostMapping("api/login")
    // public String token(@RequestBody LoginRequest userLogin){
    //     Authentication authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password()));
    //     System.out.println(authenticate);
    //     return tokenService.generateToken(authenticate);
    //}

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(), request.password()
            ));
            String accessToken = tokenService.generateToken(authentication);
            LoginResponse response = new LoginResponse(request.email(), accessToken);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            System.out.println(ex);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
