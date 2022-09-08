package com.example.space.reservation.controller;


import com.example.space.reservation.model.Reservation;
import com.example.space.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findReservationById(@PathVariable("id") Long id) {
        Optional<Reservation> reservation = Optional.of(
                                                        reservationService.findReservationById(id).orElseThrow(
                                                                () -> new RuntimeException("not found")));
        return ResponseEntity.ok().body(reservation.get());
    }



}
