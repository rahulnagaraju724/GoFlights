package com.rnagaraju.goflights.service;

import com.rnagaraju.goflights.dto.FlightDTO;
import com.rnagaraju.goflights.exception.FlightNotFoundException;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.FlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return FlightMapper.toDTOList(flights);
    }

    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight not found with id: " + id));
        return FlightMapper.toDTO(flight);
    }

    public void deleteFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
        flightRepository.delete(flight);
    }
}
