package com.Spring.Boot.FlightCheckin.Integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Spring.Boot.FlightCheckin.Integration.dto.Reservation;
import com.Spring.Boot.FlightCheckin.Integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient{
	private static final String RESERVATION_REST_URL = "http://localhost:8081/Hawa_Hawai/reservations/";

public Reservation findReservation(Long id) {
	RestTemplate restTemplate=new RestTemplate();
	Reservation reservation=restTemplate
	//.getForObject("http://localhost:8081/Hawa_Hawai"+id, Reservatio.class);
	.getForObject(RESERVATION_REST_URL+id, Reservation.class);
	return reservation;
}

public Reservation updateReservation(ReservationUpdateRequest request) {
	RestTemplate restTemplate=new RestTemplate();
	Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
	return reservation;

}}
