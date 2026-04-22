package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC6LengthAddition.QuantityLength;
import com.apps.quantitymeasurement.UC6LengthAddition.LengthUnit;

public class UC6LengthAdditionTest {

    @Test
    public void testFeetPlusFeet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(2.0, LengthUnit.FEET);

        assertTrue(a.add(b).equals(new QuantityLength(3.0, LengthUnit.FEET)));
    }

    @Test
    public void testFeetPlusInches() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(a.add(b).equals(new QuantityLength(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesPlusFeet() {
        QuantityLength a = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(a.add(b).equals(new QuantityLength(24.0, LengthUnit.INCH)));
    }

    @Test
    public void testYardPlusFeet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength b = new QuantityLength(3.0, LengthUnit.FEET);

        assertTrue(a.add(b).equals(new QuantityLength(2.0, LengthUnit.YARD)));
    }

    @Test
    public void testCentimeterPlusInch() {
        QuantityLength a = new QuantityLength(2.54, LengthUnit.CENTIMETER);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.INCH);

        QuantityLength result = a.add(b);

        assertEquals(5.08, result.unit.fromFeet(result.unit.toFeet(result.value)), 1e-2);
    }

    @Test
    public void testZero() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0.0, LengthUnit.INCH);

        assertTrue(a.add(b).equals(new QuantityLength(5.0, LengthUnit.FEET)));
    }

    @Test
    public void testNegative() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(-2.0, LengthUnit.FEET);

        assertTrue(a.add(b).equals(new QuantityLength(3.0, LengthUnit.FEET)));
    }

    @Test
    public void testNull() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }
}