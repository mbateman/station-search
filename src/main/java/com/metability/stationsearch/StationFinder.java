package com.metability.stationsearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by michael on 21/04/2015.
 */
public class StationFinder {
    static List<String> stations = Arrays.asList(new String[]{"DARTFORD", "DARTMOUTH" });

    public static List<String> lookup(String phrase) {
       List<String> nextCharacters = stations.stream().map(station -> station.substring(phrase.length(), phrase.length() + 1)).collect(Collectors.toList());
       return Stream.concat(nextCharacters.stream(), stations.stream().filter(station -> station.contains(phrase))).collect(Collectors.toList());
    }
}
