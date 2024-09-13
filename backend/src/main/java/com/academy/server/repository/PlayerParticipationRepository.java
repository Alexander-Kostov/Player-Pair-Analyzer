package com.academy.server.repository;

import com.academy.server.model.PlayerParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerParticipationRepository extends JpaRepository<PlayerParticipation, Long> {

    @Query(value = """
        WITH PlayerPeriods AS (
            SELECT
                pp1.player_id AS Player1,
                pp2.player_id AS Player2,
                pp1.game_id AS MatchId,
                GREATEST(pp1.from_minutes, pp2.from_minutes) AS start_overlap,
                LEAST(IFNULL(pp1.to_minutes, 90), IFNULL(pp2.to_minutes, 90)) AS end_overlap,
                p1.team_id AS Team1,
                p2.team_id AS Team2
            FROM
                player_participation pp1
            JOIN
                player_participation pp2 ON pp1.game_id = pp2.game_id
            JOIN
                player p1 ON pp1.player_id = p1.id
            JOIN
                player p2 ON pp2.player_id = p2.id
            WHERE
                pp1.player_id < pp2.player_id
            HAVING
                start_overlap < end_overlap
        ),
        MatchTimes AS (
            SELECT
                pp.Player1,
                pp.Player2,
                pp.MatchId,
                end_overlap - start_overlap AS time_together
            FROM
                PlayerPeriods pp
        )
        SELECT
            p1.full_name AS Player1,
            p2.full_name AS Player2,
            SUM(mt.time_together) AS total_time_together,
            GROUP_CONCAT(CONCAT('MatchId ', mt.MatchId, ': ', mt.time_together, 'm') ORDER BY mt.MatchId SEPARATOR ', ') AS match_times
        FROM
            MatchTimes mt
        JOIN
            player p1 ON mt.Player1 = p1.id
        JOIN
            player p2 ON mt.Player2 = p2.id
        GROUP BY
            mt.Player1, mt.Player2
        ORDER BY
            total_time_together DESC
        """, nativeQuery = true)
    List<Object[]> findPlayersWithMostMutualTime();


    @Query(value = """
        WITH PlayerPeriods AS (
            SELECT
                pp1.player_id AS Player1,
                pp2.player_id AS Player2,
                pp1.game_id AS MatchId,
                GREATEST(pp1.from_minutes, pp2.from_minutes) AS start_overlap,
                LEAST(IFNULL(pp1.to_minutes, 90), IFNULL(pp2.to_minutes, 90)) AS end_overlap,
                p1.team_id AS Team1,
                p2.team_id AS Team2
            FROM
                player_participation pp1
            JOIN
                player_participation pp2 ON pp1.game_id = pp2.game_id
            JOIN
                player p1 ON pp1.player_id = p1.id
            JOIN
                player p2 ON pp2.player_id = p2.id
            WHERE
                pp1.player_id < pp2.player_id
                AND p1.team_id != p2.team_id
            HAVING
                start_overlap < end_overlap
        ),
        MatchTimes AS (
            SELECT
                pp.Player1,
                pp.Player2,
                pp.MatchId,
                end_overlap - start_overlap AS time_together
            FROM
                PlayerPeriods pp
        )
        SELECT
            p1.full_name AS Player1,
            p2.full_name AS Player2,
            SUM(mt.time_together) AS total_time_together,
            GROUP_CONCAT(CONCAT('Match ', mt.MatchId, ': ', mt.time_together, ' minutes') ORDER BY mt.MatchId SEPARATOR ', ') AS match_times
        FROM
            MatchTimes mt
        JOIN
            player p1 ON mt.Player1 = p1.id
        JOIN
            player p2 ON mt.Player2 = p2.id
        GROUP BY
            mt.Player1, mt.Player2
        ORDER BY
            total_time_together DESC
        LIMIT 100;
        """, nativeQuery = true)
    List<Object[]> findPlayersWithMostMutualTimeFromDifferentTeams();
}
