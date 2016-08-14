package com.goeuro.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by etsatsina on 14-Aug-16.
 */
@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    @Id
    private int id;

    private Set<Integer> connectedStations =  new HashSet(0);
}
