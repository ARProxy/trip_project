package com.trip.controller;

import com.trip.response.SearchResponse;
import com.trip.service.SearchServcie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final SearchServcie searchServcie;
    @GetMapping()
    public ResponseEntity<List<SearchResponse>> getSearchTrip(@RequestParam("searchValue") String searchValue) {
        List<SearchResponse> searchResponse = searchServcie.getSearchTrip();
        return ResponseEntity.ok(searchResponse);
    }
}
