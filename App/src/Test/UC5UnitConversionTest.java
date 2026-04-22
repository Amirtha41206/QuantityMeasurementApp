package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC5UnitConversion.LengthUnit;

public class UC5UnitConversionTest {

    @Test
    public void testFeetToInches() {
        assertEquals(12.0,
                UC5UnitConversion.convert(1.0, LengthUnit.FEET, LengthUnit.INCH), 1e-6);
    }

    @Test
    public void testInchesToFeet() {
        assertEquals(2.0,
                UC5UnitConversion.convert(24.0, LengthUnit.INCH, LengthUnit.FEET), 1e-6);
    }

    @Test
    public void testYardToInches() {
        assertEquals(36.0,
                UC5UnitConversion.convert(1.0, LengthUnit.YARD, LengthUnit.INCH), 1e-6);
    }

    @Test
    public void testInchesToYard() {
        assertEquals(2.0,
                UC5UnitConversion.convert(72.0, LengthUnit.INCH, LengthUnit.YARD), 1e-6);
    }

    @Test
    public void testCentimeterToInch() {
        assertEquals(1.0,
                UC5UnitConversion.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH), 1e-3);
    }

    @Test
    public void testZeroValue() {
        assertEquals(0.0,
                UC5UnitConversion.convert(0.0, LengthUnit.FEET, LengthUnit.INCH), 1e-6);
    }

    @Test
    public void testNegativeValue() {
        assertEquals(-12.0,
                UC5UnitConversion.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH), 1e-6);
    }

    @Test
    public void testSameUnit() {
        assertEquals(5.0,
                UC5UnitConversion.convert(5.0, LengthUnit.FEET, LengthUnit.FEET), 1e-6);
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> UC5UnitConversion.convert(1.0, null, LengthUnit.FEET));
    }

    @Test
    public void testNaN() {
        assertThrows(IllegalArgumentException.class,
                () -> UC5UnitConversion.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH));
    }
}