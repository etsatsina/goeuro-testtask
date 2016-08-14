package com.goeuro.testtask.service.impl;

import com.goeuro.testtask.model.datasource.StationDatasource;
import com.goeuro.testtask.model.dto.RouteDto;
import com.goeuro.testtask.model.repository.StationRepository;
import com.goeuro.testtask.service.RouteProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by etsatsina on 12-Aug-16.
 */
@Service
public class RouteProviderServiceImpl implements RouteProviderService {

    private StationRepository repository;

    public RouteDto hasDirectRoute(int departureId, int arrivalId) {
        return new RouteDto(departureId, arrivalId, repository.isConnected(departureId, arrivalId));
    }

    @Autowired
    public RouteProviderServiceImpl(StationRepository repository) {
        this.repository = repository;
    }
}
