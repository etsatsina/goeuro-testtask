package com.goeuro.testtask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RouteDto {

    int departureId;

    int arrivalId;

    boolean hasDirectRoute;
}
