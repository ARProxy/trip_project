package com.trip.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayOfTripResponse {
    private String placeName;
    private String categoryName;
    private String placePositionLat;
    private String placePositionLng;
    private String photoUrls;
}
