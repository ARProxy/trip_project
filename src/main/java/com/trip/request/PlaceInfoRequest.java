package com.trip.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceInfoRequest {
    private String placeName;
    private String categoryName;
    private String placePositionLat;
    private String placePositionLng;
    private String photoUrls;
}
