package com.nam.migi_service.service;

import com.nam.migi_service.dto.request.AuthenticationRequest;
import com.nam.migi_service.dto.response.AuthenticationResponse;
import com.nam.migi_service.exception.AppException;
import com.nam.migi_service.exception.ErrorCode;
import com.nam.migi_service.repository.UserRepository;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationService {
UserRepository userRepository;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean authenticated =  passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
        if(!authenticated){
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        return
    }
    private  String generateToken (String username){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);



        JWSObject jwsObject = new JWSObject();
    }
}
