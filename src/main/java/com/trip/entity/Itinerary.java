package com.trip.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "itinenary")
@Getter
@Setter
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Day day;

    private String placeName;

    private String categoryName;

    private String placePositionLat;

    private String placePositionLng;

    private String photoUrls;
}
