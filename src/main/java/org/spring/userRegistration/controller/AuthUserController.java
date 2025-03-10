package org.spring.userRegistration.controller;

import jakarta.validation.Valid;
import org.spring.userRegistration.dto.AuthUserDTO;
import org.spring.userRegistration.dto.LoginDTO;
import org.spring.userRegistration.dto.ResponseDTO;
import org.spring.userRegistration.exception.UserException;
import org.spring.userRegistration.model.AuthUser;
import org.spring.userRegistration.service.EmailSenderService;
import org.spring.userRegistration.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody AuthUserDTO userDTO) throws Exception {

        AuthUser user = authenticationService.register(userDTO);
        ResponseDTO responseUserDTO = new ResponseDTO("User details is submitted!", user);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) throws UserException {
        String result = authenticationService.login(loginDTO);
        ResponseDTO responseUserDTO = new ResponseDTO("Login successfully!!", result);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.OK);
    }
}
