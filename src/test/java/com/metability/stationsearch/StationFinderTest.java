package com.metability.stationsearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by michael on 21/04/2015.
 */
public class StationFinderTest {

    //  Given the input ‘DART’ and a list of stations ‘DARTFORD’, ‘DARTMOUTH’, ‘TOWER HILL’, ‘DERBY’
    //  the application should return next characters of ‘F’, ‘M’ and the stations ‘DARTFORD’, ‘DARTMOUTH’.
    @Test
    public void shouldReturnNextCharactersFAndM() throws Exception {
        String searchTerm = "DART";
        List<String> stations = asList(new String[]{"DARTFORD", "DARTMOUTH", "TOWER HILL", "DERBY" });
        List<String> nextCharacters =
            stations.stream()
                .filter(station -> station.contains(searchTerm) && searchTerm.length() < station.length())
                .map(station -> station.substring(searchTerm.length(), searchTerm.length() + 1))
                .collect(toList());
        assertEquals(asList(new String[]{"F", "M" }), nextCharacters);
    }

    @Test
    public void enteringDARTShouldReturnNextCharactersFMAndDartfordDartmouthStations() throws Exception {
        List<String> stations = asList(new String[]{"DARTFORD", "DARTMOUTH", "TOWER HILL", "DERBY" });
        List<String> results = new StationFinder(stations).search("DART");
        assertEquals(asList(new String[]{"F", "M", "DARTFORD", "DARTMOUTH" }), results);
    }

    //  Given the input ‘LIVERPOOL’ and a list of stations ‘LIVERPOOL’, ‘LIVERPOOL LIME STREET’, ‘PADDINGTON’
    //  the application should return next characters of ‘ ‘ and the stations ‘LIVERPOOL’, ‘LIVERPOOL LIME STREET’
    @Test
    public void findNextEmptyCharacter() throws Exception {
        String searchTerm = "LIVERPOOL";
        List<String> stations = asList(new String[]{"LIVERPOOL", "LIVERPOOL LIME STREET", "PADDINGTON" });
        List<String> nextCharacters =
            stations.stream()
                .filter(station -> station.contains(searchTerm) && searchTerm.length() < station.length())
                .map(station -> station.substring(searchTerm.length(), searchTerm.length() + 1))
                .collect(toList());
        assertEquals(asList(new String[]{" " }), nextCharacters);
    }

    @Test
    public void enteringLiverpoolShouldReturnASpaceLiverpoolAndLiverpoolLimeStreet() throws Exception {
        List<String> stations = asList(new String[]{"LIVERPOOL", "LIVERPOOL LIME STREET", "PADDINGTON" });
        List<String> results = new StationFinder(stations).search("LIVERPOOL");
        assertEquals(asList(new String[]{" ", "LIVERPOOL", "LIVERPOOL LIME STREET" }), results);
    }

    // Given the input ‘KINGS CROSS’ and a list of stations ‘EUSTON’, ‘LONDON BRIDGE’, ‘VICTORIA’
    // the application will return no next characters and no stations
    @Test
    public void enteringUnknownStationShouldReturnNoNextCharactersAndNoStations() throws Exception {
        List<String> stations = asList(new String[]{"EUSTON", "LONDON BRIDGE", "VICTORIA" });
        List<String> results = new StationFinder(stations).search("KINGS CROSS");
        assertEquals(new ArrayList<String>(), results);
    }

}
