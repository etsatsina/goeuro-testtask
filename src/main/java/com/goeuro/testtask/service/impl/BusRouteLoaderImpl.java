package com.goeuro.testtask.service.impl;

import com.goeuro.testtask.model.Station;
import com.goeuro.testtask.model.repository.StationRepository;
import com.goeuro.testtask.service.BusRouteLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@Service
public class BusRouteLoaderImpl implements BusRouteLoader {

    private StationRepository repository;

    @Override
    public void loadRoute(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(line -> {
                Optional<List<Integer>> routeStations = getRoute(line);

                if (routeStations.isPresent()) {
                    saveStations(routeStations.get());
                }
            });
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveStations(List<Integer> routeStations) {
        int totalStationsNum = routeStations.size();

        for (int i = 0; i < totalStationsNum; i++) {
            int currentStationId = routeStations.get(i);
            List<Integer> connectedStations = routeStations.subList(i+1, totalStationsNum);

            if (connectedStations.isEmpty()) {
                break;
            }

            if (repository.contains(currentStationId)) {
                repository.get(currentStationId).addAll(connectedStations);
            }
            else {
                Station newStation = new Station();
                newStation.setId(currentStationId);
                newStation.getConnectedStations().addAll(connectedStations);

                repository.save(newStation);
            }
        }
    }

    private Optional<List<Integer>> getRoute(String str) {
        String[] strArray = str.split(" ");

        if (strArray.length > 1) {
            List<Integer> routeStations = Arrays.stream(strArray)
                    .map(stationId -> Integer.valueOf(stationId))
                    .collect(Collectors.toList());

            routeStations.remove(0);

            return Optional.of(routeStations);
        }

        return Optional.empty();
    }

    @Autowired
    public BusRouteLoaderImpl(StationRepository repository) {
        this.repository = repository;
    }
}
