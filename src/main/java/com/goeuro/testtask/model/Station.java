package com.goeuro.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    private int id;

    private Set<Integer> connectedStations =  new HashSet(0);
}
