package com.academy.server.repository;

import com.academy.server.model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetRepository extends JpaRepository<Meet, Long> {

    @Query("SELECT m.id, t1.name, t1.id, t2.name, t2.id, m.score, m.date " +
            "FROM Meet m " +
            "JOIN m.teamA t1 " +
            "JOIN m.teamB t2 " +
            "ORDER BY m.date DESC")
    List<Object[]> findAllMatchesData();
}
