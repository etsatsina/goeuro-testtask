package com.goeuro.testtask.model.datasource;

import com.goeuro.testtask.model.Station;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@Component
@Getter
@NoArgsConstructor
public class StationDatasource {

        private final HashMap<Integer, Set<Integer>> storage = new HashMap<>();
}
