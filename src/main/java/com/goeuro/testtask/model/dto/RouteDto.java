package com.goeuro.testtask.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@AllArgsConstructor
public class RouteDto {

    @JsonProperty(value = "dep_sid")
    int departureId;

    @JsonProperty(value = "arr_sid")
    int arrivalId;

    @JsonProperty(value = "direct_bus_route")
    boolean hasDirectRoute;
}
