package com.Spring.Boot.FlightCheckin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring.Boot.FlightCheckin.Integration.ReservationRestClient;
import com.Spring.Boot.FlightCheckin.Integration.dto.Reservation;
import com.Spring.Boot.FlightCheckin.Integration.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {

	@Autowired
	ReservationRestClient reservationRestClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}

@PostMapping("/startCheckIn")
public String startCheckIn(@RequestParam("reservationId")Long reservationId,ModelMap modelMap) {
	Reservation reservation=reservationRestClient.findReservation(reservationId);
	modelMap.addAttribute("reservation",reservation);
	return "displayReservationDetails";
}
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		reservationRestClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";

	}
}
