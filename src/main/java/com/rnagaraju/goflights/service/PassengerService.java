package com.rnagaraju.goflights.service;

import com.rnagaraju.goflights.dto.PassengerDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.PassengerMapper;
import com.rnagaraju.goflights.model.Passenger;
import com.rnagaraju.goflights.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public PassengerDTO getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Passenger not found with id: "+id));
        return PassengerMapper.toDTO(passenger);
    }
}
