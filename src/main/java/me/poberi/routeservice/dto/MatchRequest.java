package me.poberi.routeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRequest {
    private Location startLocation;
    private Location endLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double radius;
}
