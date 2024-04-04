package com.trip.controller;

import com.trip.kakao.KakaoLoginParams;
import com.trip.service.OAuthLoginService;
import com.trip.token.AuthTokens;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final OAuthLoginService oAuthLoginService;
    @Operation(summary = "로그인 API", description = "authorizationCode : 인가 코드")
    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}
