package com.trip.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "boards_images")
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "ori_img_name")
    private String oriImgName;

    @Column(name = "img_url")
    private String ImgUrl;

    private LocalDateTime regDate;
}
