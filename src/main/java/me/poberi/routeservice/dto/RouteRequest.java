package me.poberi.routeservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RouteRequest {
    private Location startLocation;
    private String startName;
    private Location endLocation;
    private String endName;
    private LocalDateTime startTime;
    private Long rideId;
}
