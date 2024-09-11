package com.academy.server.repository;

import com.academy.server.model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MeetRepository extends JpaRepository<Meet, Long> {

    @Query("SELECT m.id, t1.name, t1.id, t2.name, t2.id, m.score, m.date " +
            "FROM Meet m " +
            "JOIN m.teamA t1 " +
            "JOIN m.teamB t2 " +
            "ORDER BY m.date DESC")
    List<Object[]> findAllMatchesData();

    @Query(value = "SELECT m.id AS matchId, p.id AS playerId, p.full_name AS playerName, p.position AS " +
            "playerPosition, " +
            "p.team_id AS teamID, t.name AS teamName, m.score " +
            "FROM meet m " +
            "JOIN player_participation pp ON m.id = pp.game_id " +
            "JOIN player p ON p.id = pp.player_id " +
            "JOIN team t ON p.team_id = t.id " +
            "WHERE m.id = :matchId " +
            "GROUP BY p.id, t.id; ",
            nativeQuery =
            true)
    List<Object[]> getMatchDetailsById(@Param("matchId") Long matchId);



}
