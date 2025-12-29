package me.poberi.routeservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RouteRequest {
    private Location startLocation;
    private Location endLocation;
    private LocalDateTime startTime;
    private Long rideId;
}
