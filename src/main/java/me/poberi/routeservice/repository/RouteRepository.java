package me.poberi.routeservice.repository;

import me.poberi.routeservice.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
