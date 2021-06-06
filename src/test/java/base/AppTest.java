/*
 *  UCF COP3330 Summer 2021 Exercise 20 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void output_string_is_formatted_correctly() {
        App myApp = new App();

        int orderAmount = 10;
        String state = "Wisconsin";
        String county = "Dane";

        String expectedOutput = String.format("The tax is $0.50.%nThe total is $10.50.");
        String actualOutput = myApp.generateOutputString(orderAmount, state, county);

        assertEquals(expectedOutput, actualOutput);
    }
}