package com.trip.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PlaceInfoDate {
    private Map<String, List<PlaceInfoRequest>> placeMap;

    @JsonCreator
    public PlaceInfoDate(@JsonProperty("placeMap") Map<String, List<PlaceInfoRequest>> placeMap) {
        this.placeMap = placeMap;
    }
}
