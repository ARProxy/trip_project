package com.trip.service;

import com.trip.entity.Member;
import com.trip.repository.MemberRepository;
import com.trip.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingService {

    private final MemberRepository memberRepository;

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

    public MyPageResponse getMyPage() {
        MyPageResponse myPageResponse = new MyPageResponse();
        Member member = memberRepository.findById(member().getId()).orElseThrow();
        myPageResponse.setNickname(member.getNickname());
        System.out.println(member.getNickname());
        myPageResponse.setPhotoUrl(member.getProfile_image_url());
        return myPageResponse;
    }
}
