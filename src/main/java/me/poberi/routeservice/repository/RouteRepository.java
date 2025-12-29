package me.poberi.routeservice.repository;

import me.poberi.routeservice.model.Route;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query(value = """
    SELECT *
    FROM routes r
    WHERE ST_DWithin(
            r.startlocation::geography,
            ST_SetSRID(:start, 4326)::geography,
            :radius
          )
      AND ST_DWithin(
            r.endlocation::geography,
            ST_SetSRID(:end, 4326)::geography,
            :radius
          )
      AND r.starttime BETWEEN :startTime AND :endTime
    """, nativeQuery = true)
    List<Route> findMatchingRoutes(
            @Param("start") Point start,
            @Param("end") Point end,
            @Param("radius") double radius,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}
