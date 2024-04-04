package com.trip.repository;

import com.trip.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b WHERE b.member.id = :memberId ORDER BY b.id")
    Page<Board> findByMemberIdAndRecently(@Param("memberId") Long memberId, Pageable pageable);

}
