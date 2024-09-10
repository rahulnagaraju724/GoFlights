package com.rnagaraju.goflights.controller;

import com.rnagaraju.goflights.dto.PassengerDTO;
import com.rnagaraju.goflights.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/")
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        List<PassengerDTO> passengerDTOS= passengerService.getAllPassengers();
        if(passengerDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(passengerDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassenger(@PathVariable("id") Long id) {
        PassengerDTO passengerDTO = passengerService.getPassengerById(id);
        return ResponseEntity.ok(passengerDTO);
    }

}
