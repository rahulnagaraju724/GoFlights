package com.rnagaraju.goflights.repository;

import com.rnagaraju.goflights.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
