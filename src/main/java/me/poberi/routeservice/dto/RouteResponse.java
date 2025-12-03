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
    private Location endLocation;
    private LocalDateTime startTime;
}
