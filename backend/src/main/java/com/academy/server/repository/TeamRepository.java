package com.academy.server.repository;

import com.academy.server.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT p.id, t.name, p.teamNumber, p.fullName, p.position " +
            "FROM Player p JOIN p.team t " +
            "WHERE t.id = :teamId")
    List<Object[]> findPlayerDataByTeamId(@Param("teamId") Long teamId);

}
