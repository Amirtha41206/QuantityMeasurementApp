package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC7AdditionWithTargetUnit.QuantityLength;
import com.apps.quantitymeasurement.UC7AdditionWithTargetUnit.LengthUnit;

public class UC7AdditionWithTargetUnitTest {

    @Test
    public void testAddition_TargetFeet() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(
                a.add(b, LengthUnit.FEET)
                        .equals(new QuantityLength(2.0, LengthUnit.FEET))
        );
    }

    @Test
    public void testAddition_TargetInches() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(
                a.add(b, LengthUnit.INCH)
                        .equals(new QuantityLength(24.0, LengthUnit.INCH))
        );
    }

    @Test
    public void testAddition_TargetYards() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result =
                a.add(b, LengthUnit.YARD);

        assertEquals(0.666, result.value, 1e-2);
    }

    @Test
    public void testAddition_TargetCentimeter() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.INCH);

        QuantityLength b =
                new QuantityLength(1.0, LengthUnit.INCH);

        QuantityLength result =
                a.add(b, LengthUnit.CENTIMETER);

        assertEquals(5.08, result.value, 1e-1);
    }

    @Test
    public void testAddition_Commutativity() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(
                a.add(b, LengthUnit.YARD)
                        .equals(
                                b.add(a, LengthUnit.YARD)
                        )
        );
    }

    @Test
    public void testAddition_Zero() {

        QuantityLength a =
                new QuantityLength(5.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(0.0, LengthUnit.INCH);

        QuantityLength result =
                a.add(b, LengthUnit.YARD);

        assertEquals(1.666, result.value, 1e-2);
    }

    @Test
    public void testAddition_Negative() {

        QuantityLength a =
                new QuantityLength(5.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(-2.0, LengthUnit.FEET);

        assertTrue(
                a.add(b, LengthUnit.INCH)
                        .equals(new QuantityLength(36.0, LengthUnit.INCH))
        );
    }

    @Test
    public void testAddition_NullTargetUnit() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCH);

        assertThrows(
                IllegalArgumentException.class,
                () -> a.add(b, null)
        );
    }
}