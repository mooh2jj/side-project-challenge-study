package com.study.sidejavachallenge.domain.member.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import com.study.sidejavachallenge.domain.team.entity.Team;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "team")
@Table(name = "members")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String memberName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public Member(Long id, String memberName, Team team) {
        this.id = id;
        this.memberName = memberName;
        this.team = team;
    }
}
