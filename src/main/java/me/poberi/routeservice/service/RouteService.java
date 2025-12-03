package me.poberi.routeservice.service;

import lombok.RequiredArgsConstructor;
import me.poberi.routeservice.dto.RouteRequest;
import me.poberi.routeservice.dto.RouteResponse;
import me.poberi.routeservice.mapper.RouteMapper;
import me.poberi.routeservice.model.Route;
import me.poberi.routeservice.repository.RouteRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;

    public RouteResponse createRoute(RouteRequest req) {
        Point startLocation = geometryFactory.createPoint(
                new Coordinate(req.getStartLocation().longitude(), req.getStartLocation().latitude()));
        startLocation.setSRID(4326);

        Point endLocation = geometryFactory.createPoint(
                new Coordinate(req.getEndLocation().longitude(), req.getEndLocation().latitude()));
        endLocation.setSRID(4326);

        Route route = new Route();
        route.setEndLocation(endLocation);
        route.setStartLocation(startLocation);
        route.setStartTime(req.getStartTime());

        return routeMapper.toResponse(routeRepository.save(route));
    }
}
