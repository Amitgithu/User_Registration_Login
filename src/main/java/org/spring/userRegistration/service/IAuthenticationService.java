package org.spring.userRegistration.service;

import org.spring.userRegistration.dto.AuthUserDTO;
import org.spring.userRegistration.dto.LoginDTO;
import org.spring.userRegistration.exception.UserException;
import org.spring.userRegistration.model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO) throws UserException;
}
