package com.udacity.maccars.vehiclesapi.client.maps;


import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.udacity.maccars.vehiclesapi.domains.Location;
/**
 * Implements a class to interface with the Maps Client for location data.
 */
@Component
public class MapsClient {

    private static final Logger log = LoggerFactory.getLogger(MapsClient.class);

    private final WebClient client;
    private final ModelMapper mapper;

    public MapsClient(WebClient maps,
                      ModelMapper mapper) {
        this.client = maps;
        this.mapper = mapper;
    }


    public Location getAddress(Location location) {
        try {
            Address address = client
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/maps")
                            .queryParam("lat", location.getLat())
                            .queryParam("lon", location.getLon())
                            .build())
                    .retrieve().bodyToMono(Address.class).block();
            mapper.map(Objects.requireNonNull(address), location);
            return location;

        } catch (
                Exception e) {
            log.warn("Map service is down");
            return location;
        }
    }
}
