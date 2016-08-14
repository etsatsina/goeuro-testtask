package com.goeuro.testtask.model.repository;

import com.goeuro.testtask.model.Station;

import java.util.Set;

/**
 * Created by etsatsina on 14-Aug-16.
 */
public interface StationRepository {

    Station save(Station station);

    Set<Integer> get(Integer id);

    boolean contains(Integer id);

    boolean isConnected(int departureId, int arrivalId);
}
