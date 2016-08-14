package com.goeuro.testtask.model.repository;

import com.goeuro.testtask.model.Station;
import com.goeuro.testtask.model.datasource.StationDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@Repository
public class StationInternalRepository implements StationRepository {

    private StationDatasource datasource;

    @Autowired
    public StationInternalRepository(StationDatasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public Station save(Station station) {
        datasource.getStorage().put(station.getId(), station.getConnectedStations());
        return station;
    }

    @Override
    public Set<Integer> get(Integer id) {
        return datasource.getStorage().get(id);
    }

    @Override
    public boolean contains(Integer id) {
        return datasource.getStorage().containsKey(id);
    }

    @Override
    public boolean isConnected(int departureId, int arrivalId) {
        boolean isConnected = false;

        if (datasource.getStorage().containsKey(departureId)) {
            isConnected = datasource.getStorage().get(departureId).contains(arrivalId);
        }

        return isConnected;
    }
}
