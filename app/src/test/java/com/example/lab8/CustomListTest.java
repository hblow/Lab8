package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Test if hasCity method works
     * Checks if empty list has list
     * Adds city then checks if city list has city
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        assertFalse(list.hasCity(city), "City should not exist in list");
        list.addCity(city);
        assertTrue(list.hasCity(city), "City should exist in list");

    }

    /**
     * Test if deleteCity method works
     * Add city to list and check if in list
     * Delete city from list and check if city has list
     * Check if method throws exception if given city not in list
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {list.deleteCity(city);});
    }

    /**
     * Test if countCities method works
     * Check if initial list contains 0 items
     * Add city to list
     * Check if list contains 1 item
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        assertEquals(0, list.countCities());
        list.addCity(city);
        assertEquals(1, list.countCities());
    }

}
