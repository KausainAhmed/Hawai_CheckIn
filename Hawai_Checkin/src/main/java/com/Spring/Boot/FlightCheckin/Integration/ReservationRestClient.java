package com.Spring.Boot.FlightCheckin.Integration;

import com.Spring.Boot.FlightCheckin.Integration.dto.Reservation;
import com.Spring.Boot.FlightCheckin.Integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
public Reservation findReservation(Long id);
public Reservation updateReservation(ReservationUpdateRequest request);
}
