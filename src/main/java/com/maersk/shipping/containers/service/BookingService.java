package com.maersk.shipping.containers.service;

import com.maersk.shipping.containers.dto.request.ContainerRequirementDto;
import com.maersk.shipping.containers.dto.response.AvailableBookingsResponseDto;
import com.maersk.shipping.containers.dto.response.AvailableContainerSpace;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BookingService {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://maersk.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public AvailableBookingsResponseDto checkAvailableBookings(ContainerRequirementDto containerRequirementDto) {
        boolean isBookingsAvailable = checkBookingEligibility(containerRequirementDto);

        AvailableBookingsResponseDto availableBookings = new AvailableBookingsResponseDto();
        availableBookings.setAvailable(isBookingsAvailable);

        return availableBookings;
    }

    private boolean checkBookingEligibility(ContainerRequirementDto containerRequirementDto) {
        AvailableContainerSpace containersAvailable = webClient.post()
                .uri("/api/bookings/checkAvailable")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(containerRequirementDto), ContainerRequirementDto.class)
                .retrieve()
                .bodyToMono(AvailableContainerSpace.class)
                .block();

        assert containersAvailable != null;
        return containersAvailable.getAvailableSpace() != 0;
    }
}
