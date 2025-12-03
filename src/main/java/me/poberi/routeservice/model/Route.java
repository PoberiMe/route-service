package me.poberi.routeservice.model;

import jakarta.persistence.*;
import lombok.*;

import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point startLocation;
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point endLocation;
    private LocalDateTime startTime;
}
