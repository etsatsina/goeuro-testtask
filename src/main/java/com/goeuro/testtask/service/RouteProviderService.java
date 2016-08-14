package com.goeuro.testtask.service;

import com.goeuro.testtask.model.dto.RouteDto;

/**
 * Created by etsatsina on 12-Aug-16.
 */
public interface RouteProviderService {

    RouteDto hasDirectRoute(int departureId, int arrivalId);
}
