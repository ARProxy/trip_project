package com.trip.response;

import com.trip.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SearchResponse {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String destination;
    private int likesCount;
    private boolean isLiked;
    private String nickname;
    private String profileUrl;

}
