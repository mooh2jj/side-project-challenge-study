package com.study.sidejavachallenge.domain.team.repository;

import com.study.sidejavachallenge.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
