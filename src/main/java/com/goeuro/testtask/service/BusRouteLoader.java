package com.goeuro.testtask.service;

import java.util.List;

/**
 * Created by etsatsina on 14-Aug-16.
 */
public interface BusRouteLoader extends RouteLoader {

    void loadRoute(String filename);

    void saveStations(List<Integer> routeStations);
}
