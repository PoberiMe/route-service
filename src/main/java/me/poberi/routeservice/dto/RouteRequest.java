package me.poberi.routeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    private Location startLocation;
    private Location endLocation;
    private LocalDateTime startTime;
}
