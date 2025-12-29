package me.poberi.routeservice.service;

import lombok.RequiredArgsConstructor;
import me.poberi.routeservice.dto.MatchRequest;
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

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;

    public RouteResponse createRoute(RouteRequest req) {
        Point startLocation = geometryFactory.createPoint(
                new Coordinate(req.getStartLocation().lng(), req.getStartLocation().lat()));
        startLocation.setSRID(4326);

        Point endLocation = geometryFactory.createPoint(
                new Coordinate(req.getEndLocation().lng(), req.getEndLocation().lat()));
        endLocation.setSRID(4326);

        Route route = new Route();
        route.setEndLocation(endLocation);
        route.setStartLocation(startLocation);
        route.setStartTime(req.getStartTime());
        route.setRouteId(req.getRideId());
        route.setStartName(req.getStartName());
        route.setEndName(req.getEndName());

        return routeMapper.toResponse(routeRepository.save(route));
    }

    public List<RouteResponse> matchRoutes(MatchRequest req) {

        Point start = geometryFactory.createPoint(
                new Coordinate(
                        req.getStartLocation().lng(),
                        req.getStartLocation().lat()
                )
        );
        start.setSRID(4326);

        Point end = geometryFactory.createPoint(
                new Coordinate(
                        req.getEndLocation().lng(),
                        req.getEndLocation().lat()
                )
        );
        end.setSRID(4326);

        List<Route> resultList = routeRepository.findMatchingRoutes(
                start,
                end,
                req.getRadius(),
                req.getStartTime(),
                req.getEndTime()
        );

        List<RouteResponse> responseList = new java.util.ArrayList<>();

        for (Route route : resultList) {
            responseList.add(routeMapper.toResponse(route));
        }

        return responseList;

    }
}
