package com.metability.stationsearch;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by michael on 21/04/2015.
 */
public class StationFinder {
    private List<String> stations;

    public StationFinder(List<String> stations) {
        this.stations = stations;
    }

    public List<String> search(String searchTerm) {
        Stream<String> nextCharacters =
            stations.stream()
                .filter(station -> station.contains(searchTerm) && searchTerm.length() < station.length())
                .map(station -> station.substring(searchTerm.length(), searchTerm.length() + 1));
        return Stream.concat(
             nextCharacters,
             stations.stream()
                .filter(station -> station.contains(searchTerm)))
                .collect(toList());
    }
}
