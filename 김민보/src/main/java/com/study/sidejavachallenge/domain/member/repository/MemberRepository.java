package com.study.sidejavachallenge.domain.member.repository;

import com.study.sidejavachallenge.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
