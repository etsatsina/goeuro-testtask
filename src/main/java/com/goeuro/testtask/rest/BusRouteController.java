package com.goeuro.testtask.rest;

import com.goeuro.testtask.model.dto.RouteDto;
import com.goeuro.testtask.service.RouteProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by etsatsina on 12-Aug-16.
 */
@RestController
@RequestMapping("rest/provider/goeurobus")
public class BusRouteController {

    private RouteProviderService routeProvider;

    @RequestMapping(value = "/direct/{dep_sid}/{arr_sid}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RouteDto hasDirectRoute(@PathVariable("dep_sid") int departureId, @PathVariable("arr_sid") int arrivalId) {
        return routeProvider.hasDirectRoute(departureId, arrivalId);
    }

    @Autowired
    public BusRouteController(RouteProviderService routeProvider) {
        this.routeProvider = routeProvider;
    }
}
