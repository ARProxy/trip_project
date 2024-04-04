package com.trip.controller;

import com.trip.request.BoardRequest;
import com.trip.response.ComingTripResponse;
import com.trip.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@CrossOrigin
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/coming")
    public ResponseEntity<ComingTripResponse> comingTrip() {
        ComingTripResponse comingTripResponse = boardService.getBoard();
        return ResponseEntity.ok(comingTripResponse);
    }

    @GetMapping("/past")
    public ResponseEntity<Void> pastTrip() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Void> addTrip(@RequestBody BoardRequest boardRequest) {
        System.out.println(boardRequest.getPlaceInfo().keySet());
        boardService.addBoard(boardRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<Void> updateTrip(@RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok().build();
    }
    @DeleteMapping()
    public ResponseEntity<Void> deleteTrip(@RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok().build();
    }

}
