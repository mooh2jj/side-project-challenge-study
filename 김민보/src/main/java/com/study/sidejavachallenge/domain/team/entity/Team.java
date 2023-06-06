package com.study.sidejavachallenge.domain.team.entity;

import com.study.sidejavachallenge.domain.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column
    private String teamName;

    @Builder
    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }
}
