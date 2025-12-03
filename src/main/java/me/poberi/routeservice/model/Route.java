package me.poberi.routeservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.locationtech.jts.geom.Point;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point startPoint;
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point endPoint;
}
