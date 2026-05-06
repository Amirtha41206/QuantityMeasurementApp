import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC8RefactoredQuantityLength.QuantityLength;

public class UC8RefactoredQuantityLengthTest {

    @Test
    public void testConvertToBaseUnit_InchToFeet() {

        assertEquals(
                1.0,
                LengthUnit.INCH.convertToBaseUnit(12.0),
                1e-6
        );
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInch() {

        assertEquals(
                12.0,
                LengthUnit.INCH.convertFromBaseUnit(1.0),
                1e-6
        );
    }

    @Test
    public void testEquality() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testConvertTo() {

        QuantityLength q =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result =
                q.convertTo(LengthUnit.INCH);

        assertTrue(
                result.equals(
                        new QuantityLength(
                                12.0,
                                LengthUnit.INCH
                        )
                )
        );
    }

    @Test
    public void testAddition() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result =
                q1.add(q2, LengthUnit.FEET);

        assertTrue(
                result.equals(
                        new QuantityLength(
                                2.0,
                                LengthUnit.FEET
                        )
                )
        );
    }

    @Test
    public void testAddition_TargetYard() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result =
                q1.add(q2, LengthUnit.YARD);

        assertEquals(
                0.666,
                result.convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .convertTo(LengthUnit.YARD)
                        .value,
                1e-2
        );
    }

    @Test
    public void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }

    @Test
    public void testInvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(Double.NaN, LengthUnit.FEET)
        );
    }
}