package com.study.sidejavachallenge.domain.member.entity;

import com.study.sidejavachallenge.domain.member.repository.MemberRepository;
import com.study.sidejavachallenge.domain.team.entity.Team;
import com.study.sidejavachallenge.domain.team.repository.TeamRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Log4j2
class MemberTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private TeamRepository teamRepository;

    private Member member1, member2;

    @BeforeEach
    void setup() {

        Team team = Team.builder()
                .id(1L)
                .teamName("team")
                .build();

        teamRepository.save(team);

        member1 = Member.builder()
                .id(1L)
                .memberName("member1")
                .team(team)
                .build();

        member2 = Member.builder()
                .id(2L)
                .memberName("member2")
                .team(team)
                .build();
    }

    @Test
    @DisplayName("lazy loading test")
    void test() {

        // given
        memberRepository.save(member1);

        // when
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("멤버가 없습니다"));

        // then
        log.info("member : {}", member);
    }
}