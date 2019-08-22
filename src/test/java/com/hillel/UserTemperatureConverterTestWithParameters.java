package com.hillel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserTemperatureConverterTestWithParameters {
    private TemperatureConverter temperatureConvertor;
    private UsersHolderInCsv usersHolder;
    private User user;

    @BeforeClass
    public void setUp() {
        temperatureConvertor = new TemperatureConverter();
        usersHolder = new UsersHolderInCsv();
        usersHolder.loadAll();
    }

    @Parameters({"userId", "celsius", "expectedResult"})
    @Test
    public void UserTemperatureConverterTestWithParameters(int id, double celsius, double expectedResult) {
        user = usersHolder.findUserById(id);
        double result = temperatureConvertor.convertCelsiusToKelvin(user,celsius);
        assertEquals(result, expectedResult);
    }
}
