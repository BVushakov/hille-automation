package com.hillel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserTemperatureConverterTest {
    private TemperatureConverter temperatureConvertor;
    private UsersHolderInCsv usersHolder;
    private User user;

    @BeforeClass
    public void setUp() {
        temperatureConvertor = new TemperatureConverter();
        usersHolder = new UsersHolderInCsv();
        usersHolder.loadAll();
    }

//    @Test
//    public void adminUserTemperatureConverterTest() {
//        user = usersHolder.findUserById(1);
//        double result = temperatureConvertor.convertCelsiusToKelvin(user,25.0);
//        assertEquals(result, 125.0);
//    }
//
//    @Test
//    public void userUserTemperatureConverterTest() {
//        user = usersHolder.findUserById(2);
//        double result = temperatureConvertor.convertCelsiusToKelvin(user,25.0);
//        assertEquals(result, 225.0);
//    }
//    @Test
//    public void notLoggedUserTemperatureConverterTest() {
//        user = usersHolder.findUserById(3);
//        double result = temperatureConvertor.convertCelsiusToKelvin(user,25.0);
//        assertEquals(result, 325.0);
//    }

    @Test(dataProvider = "user")
    public void userTemperatureConverterTestWithData(int id, double celsius, double expectedResult) {
        user = usersHolder.findUserById(id);
        double result = temperatureConvertor.convertCelsiusToKelvin(user,celsius);
        assertEquals(result, expectedResult);
    }

    @DataProvider(name = "user")
    public Object[][] createData1() {
        return new Object[][] {
                { 1, 25.0, 125 },
                { 2, 25.0, 225 },
                { 3, 25.0, 325 }
        };
    }
}
