package me.poberi.routeservice.mapper;

import me.poberi.routeservice.dto.Location;
import me.poberi.routeservice.dto.RouteResponse;
import me.poberi.routeservice.model.Route;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public RouteResponse toResponse(Route route) {
        return new RouteResponse(
                route.getId(),
                toLocation(route.getStartLocation()),
                route.getStartName(),
                toLocation(route.getEndLocation()),
                route.getEndName(),
                route.getStartTime(),
                route.getRouteId()
        );
    }

    private Location toLocation(Point point) {
        return new Location(
                point.getY(), // lat
                point.getX()
        );
    }
}
