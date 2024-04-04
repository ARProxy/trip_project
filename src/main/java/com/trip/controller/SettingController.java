package com.trip.controller;

import com.trip.response.MyPageResponse;
import com.trip.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/setting")
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/myPage")
    public ResponseEntity<MyPageResponse> getMyPage() {
        MyPageResponse myPageResponse = settingService.getMyPage();
        return ResponseEntity.ok(myPageResponse);
    }
}