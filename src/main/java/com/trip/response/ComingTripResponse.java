package com.trip.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ComingTripResponse {
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private Map<Integer, List<DayOfTripResponse>> dayList;
}
