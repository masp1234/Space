package com.example.space.reservation.service;

import com.example.space.reservation.model.Reservation;
import com.example.space.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);

    }
}
