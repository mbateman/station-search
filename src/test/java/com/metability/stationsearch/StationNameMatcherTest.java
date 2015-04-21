package com.metability.stationsearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by michael on 21/04/2015.
 */
public class StationNameMatcherTest {

//    • Given the input ‘DART’ and a list of stations ‘DARTFORD’, ‘DARTMOUTH’, ‘TOWER HILL’, ‘DERBY’
//    the application should return next characters of ‘F’, ‘M’ and the stations ‘DARTFORD’, ‘DARTMOUTH’.

    @Test
    public void findNextCharacters() throws Exception {
        String phrase = "DART";
        List<String> stations = Arrays.asList(new String[]{"DARTFORD", "DARTMOUTH" });
        List<String> nextCharacters = stations.stream().map(station -> station.substring(phrase.length(), phrase.length() + 1)).collect(Collectors.toList());
        assertEquals(Arrays.asList(new String[]{"F", "M"}), nextCharacters);
    }

    @Test
    public void enteringDARTShouldReturnNextCharactersFMAndDartfordDartmouthStations() throws Exception {
        List<String> results = StationFinder.lookup("DART");
        assertEquals(Arrays.asList(new String[]{"F", "M", "DARTFORD", "DARTMOUTH" }), results);
    }

//    • Given the input ‘LIVERPOOL’ and a list of stations ‘LIVERPOOL’, ‘LIVERPOOL LIME STREET’, ‘PADDINGTON’
//    the application should return next characters of ‘ ‘ and the stations ‘LIVERPOOL’, ‘LIVERPOOL LIME STREET’

//    • Given the input ‘KINGS CROSS’ and a list of stations ‘EUSTON’, ‘LONDON BRIDGE’, ‘VICTORIA’
//    the application will return no next characters and no stations
}
