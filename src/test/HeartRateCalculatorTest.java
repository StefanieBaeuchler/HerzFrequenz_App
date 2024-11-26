package test;

import main.HeartRateCalculator;
import main.exceptions.InvalidInputException;
import main.exceptions.InvalidZoneException;
import main.exceptions.InvalidHeartRateException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeartRateCalculatorTest {

    HeartRateCalculator calculator = new HeartRateCalculator();

    @Test
    void testStringToInteger_ValidInput() throws InvalidInputException {
        assertEquals(42, calculator.stringToInteger("42"));
    }

    @Test
    void testStringToInteger_InvalidInput() {
        assertThrows(InvalidInputException.class, () -> {
            calculator.stringToInteger("abc");
        });
    }

    @Test
    void testCalcTargetHeartRate_ValidInputs() throws Exception {
        assertEquals(108, calculator.calcTargetHeartRate(180, 1));  // Anpassen des erwarteten Wertes
    }

    @Test
    void testCalcTargetHeartRate_InvalidZone() {
        assertThrows(InvalidZoneException.class, () -> {
            calculator.calcTargetHeartRate(180, 6);
        });
    }

    @Test
    void testCalcTargetHeartRate_InvalidMaxHF() {
        assertThrows(InvalidHeartRateException.class, () -> {
            calculator.calcTargetHeartRate(0, 3);
        });
    }

    @Test
    void testCalcTargetHeartRate_RoundingDown() throws Exception {
        assertEquals(160, calculator.calcTargetHeartRate(201, 3));
    }

    @Test
    void testCalcTargetHeartRate_ExtremeHighValue() throws Exception {
        assertEquals(Integer.MAX_VALUE, calculator.calcTargetHeartRate(Integer.MAX_VALUE, 5));
    }

    @Test
    void testStringToInteger_WrittenNull() {
        assertThrows(InvalidInputException.class, () -> {
            calculator.stringToInteger("null");
        });
    }

    @Test
    void testStringToInteger_EmptyString() {
        assertThrows(InvalidInputException.class, () -> {
            calculator.stringToInteger("");
        });
    }

}
