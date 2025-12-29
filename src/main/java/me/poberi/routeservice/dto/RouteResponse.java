package me.poberi.routeservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {
    private Long id;
    private Location startLocation;
    private String startName;
    private Location endLocation;
    private String endName;
    private LocalDateTime startTime;
    private Long rideId;
}
