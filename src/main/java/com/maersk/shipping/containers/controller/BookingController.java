package com.maersk.shipping.containers.controller;

import com.maersk.shipping.containers.dto.request.ContainerRequirementDto;
import com.maersk.shipping.containers.dto.response.AvailableBookingsResponseDto;
import com.maersk.shipping.containers.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/api/bookings")
    public ResponseEntity<AvailableBookingsResponseDto> checkAvailableBookings(@RequestBody @Valid ContainerRequirementDto containerRequirementDto) {
        return ResponseEntity.ok(bookingService.checkAvailableBookings(containerRequirementDto));
    }
}
