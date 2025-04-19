package com.nam.migi_service.controller;

import com.nam.migi_service.dto.request.ApiResponse;
import com.nam.migi_service.dto.request.AuthenticationRequest;
import com.nam.migi_service.dto.response.AuthenticationResponse;
import com.nam.migi_service.entity.User;
import com.nam.migi_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
AuthenticationService authenticationService;
    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        boolean result =  authenticationService.authenticate(authenticationRequest);
        return  ApiResponse.<AuthenticationResponse>builder()
            .result(AuthenticationResponse.builder()
                    .authenticated(result)
                    .build())
            .build();
    }

}
