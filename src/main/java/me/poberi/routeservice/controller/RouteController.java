package me.poberi.routeservice.controller;


import lombok.RequiredArgsConstructor;
import me.poberi.routeservice.dto.MatchRequest;
import me.poberi.routeservice.dto.RouteRequest;
import me.poberi.routeservice.dto.RouteResponse;
import me.poberi.routeservice.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RouteResponse createRoute(@RequestBody RouteRequest route) {
        return routeService.createRoute(route);
    }

    @PostMapping("/match")
    public List<RouteResponse> matchRoutes(@RequestBody MatchRequest request) {
        return routeService.matchRoutes(request);
    }
}
