package com.trip.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping(value = "soon")
    public ResponseEntity<?> getSoon() {
        return null;
    }

    @GetMapping(value = "before")
    public ResponseEntity<?> getBefore() {
        return null;
    }
}
