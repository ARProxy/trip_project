package com.trip.request;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BoardRequest {
    private Map<String, List<PlaceInfoRequest>> placeInfo;
    private String city;
    private String startDate;
    private String endDate;
}
