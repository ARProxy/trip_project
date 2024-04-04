package com.trip.response;

import com.trip.entity.Image;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PostResponse {

    private String nickname;
    private String profileUrl;
    private List<Image> images;
    private String destination;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Map<String, List<String>>> dayList;
    private int likesCount;
    private boolean isLiked;

}
