package com.trip.service;

import com.trip.entity.Board;
import com.trip.entity.Day;
import com.trip.entity.Itinerary;
import com.trip.entity.Member;
import com.trip.repository.BoardRepository;
import com.trip.repository.DayRepository;
import com.trip.repository.ItineraryRepository;
import com.trip.repository.MemberRepository;
import com.trip.request.BoardRequest;
import com.trip.request.PlaceInfoRequest;
import com.trip.response.ComingTripResponse;
import com.trip.response.DayOfTripResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final DayRepository dayRepository;
    private final ItineraryRepository itineraryRepository;

    private Member member() {
        return memberRepository
                .findByEmail(
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName()
                )
                .orElseThrow(
                        () -> new IllegalStateException("다시 로그인 해주세요!!")
                );
    }

    public void addBoard(BoardRequest boardRequest) {
        Board board = new Board();
        board.setMember(member());
        board.setCity(boardRequest.getCity());
        board.setRegDate(LocalDateTime.now());
        board.setStartDate(LocalDate.parse(boardRequest.getStartDate()));
        board.setEndDate(LocalDate.parse(boardRequest.getEndDate()));
        boardRepository.save(board);
        int iteration = 0;

        for(Map.Entry<String, List<PlaceInfoRequest>> entry : boardRequest.getPlaceInfo().entrySet()) {
            String key = entry.getKey();
            Day day = new Day();
            day.setDayOfTrip(Integer.valueOf(key));
            day.setBoard(board);
            dayRepository.save(day);

            for (PlaceInfoRequest place : entry.getValue()) {
                Itinerary itinerary = new Itinerary();
                itinerary.setDay(day);
                itinerary.setPlaceName(place.getPlaceName());
                itinerary.setCategoryName(place.getCategoryName());
                itinerary.setPlacePositionLat(place.getPlacePositionLat());
                itinerary.setPlacePositionLng(place.getPlacePositionLng());
                itinerary.setPhotoUrls(place.getPhotoUrls());
                itineraryRepository.save(itinerary);
            }
        }
    }

    public ComingTripResponse getBoard() {
        Long memberId = member().getId();
        Page<Board> boardPage = boardRepository.findByMemberIdAndRecently(memberId, PageRequest.of(0, 1));
        if (boardPage.hasContent()) {
            Board board = boardPage.getContent().get(0); // Get the first (and only) board
            Long boardId = board.getId();
            ComingTripResponse comingTripResponse = new ComingTripResponse();
            comingTripResponse.setCity(board.getCity());
            comingTripResponse.setStartDate(board.getStartDate());
            comingTripResponse.setEndDate(board.getEndDate());
            Map<Integer, List<DayOfTripResponse>> dayMap = new HashMap<>();
            List<Day> day = dayRepository.findByBoardId(boardId);
            int i = 0;
            for(Day da : day) {
                List<Itinerary> list = itineraryRepository.findByDayId(da.getId());
                List<DayOfTripResponse> dayList = new ArrayList<>();
                for(Itinerary itinerary : list) {
                    DayOfTripResponse dayOfTripResponse = new DayOfTripResponse();
                    dayOfTripResponse.setPlaceName(itinerary.getPlaceName());
                    dayOfTripResponse.setPhotoUrls(itinerary.getPhotoUrls());
                    dayOfTripResponse.setPlacePositionLng(itinerary.getPlacePositionLng());
                    dayOfTripResponse.setPlacePositionLat(itinerary.getPlacePositionLat());
                    dayOfTripResponse.setCategoryName(itinerary.getCategoryName());
                    dayList.add(dayOfTripResponse);
                }
                dayMap.put(i++, dayList);
            }
            comingTripResponse.setDayList(dayMap);
            return comingTripResponse;
        }

        return null;
//        Board board = boardRepository.findByMemberIdAndRecently(memberId, PageRequest.of(0, 1));
//        Long boardId = board.getId();
//        ComingTripResponse comingTripResponse = new ComingTripResponse();
//        comingTripResponse.setCity(board.getCity());
//        comingTripResponse.setStartDate(board.getStartDate());
//        comingTripResponse.setEndDate(board.getEndDate());
//        Map<Integer, List<DayOfTripResponse>> dayMap = new HashMap<>();
//        List<Day> day = dayRepository.findByBoardId(boardId);
//        int i = 0;
//        for(Day da : day) {
//            List<Itinerary> list = itineraryRepository.findByDayId(da.getId());
//            List<DayOfTripResponse> dayList = new ArrayList<>();
//            for(Itinerary itinerary : list) {
//                DayOfTripResponse dayOfTripResponse = new DayOfTripResponse();
//                dayOfTripResponse.setPlaceName(itinerary.getPlaceName());
//                dayOfTripResponse.setPhotoUrls(itinerary.getPhotoUrls());
//                dayOfTripResponse.setPlacePositionLng(itinerary.getPlacePositionLng());
//                dayOfTripResponse.setPlacePositionLat(itinerary.getPlacePositionLat());
//                dayOfTripResponse.setCategoryName(itinerary.getCategoryName());
//                dayList.add(dayOfTripResponse);
//            }
//            dayMap.put(i++, dayList);
//        }
//        comingTripResponse.setDayList(dayMap);
//        return comingTripResponse;
    }
}
