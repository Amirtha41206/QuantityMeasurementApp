import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import UC9QuantityWeight.QuantityWeight;

public class UC9QuantityWeightTest {

    @Test
    public void testKilogramEquality() {

        QuantityWeight q1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testPoundEquality() {

        QuantityWeight q1 =
                new QuantityWeight(1.0, WeightUnit.POUND);

        QuantityWeight q2 =
                new QuantityWeight(453.592, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testConvertKilogramToGram() {

        QuantityWeight q =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result =
                q.convertTo(WeightUnit.GRAM);

        assertTrue(
                result.equals(
                        new QuantityWeight(
                                1000.0,
                                WeightUnit.GRAM
                        )
                )
        );
    }

    @Test
    public void testConvertKilogramToPound() {

        QuantityWeight q =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result =
                q.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.convertTo(WeightUnit.POUND)
                .convertTo(WeightUnit.POUND)
                .value, 1e-3);
    }

    @Test
    public void testAdditionKilogramAndGram() {

        QuantityWeight q1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result =
                q1.add(q2);

        assertTrue(
                result.equals(
                        new QuantityWeight(
                                2.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testAdditionExplicitTarget() {

        QuantityWeight q1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result =
                q1.add(q2, WeightUnit.GRAM);

        assertTrue(
                result.equals(
                        new QuantityWeight(
                                2000.0,
                                WeightUnit.GRAM
                        )
                )
        );
    }

    @Test
    public void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(
                        1.0,
                        null
                )
        );
    }

    @Test
    public void testInvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(
                        Double.NaN,
                        WeightUnit.KILOGRAM
                )
        );
    }

    @Test
    public void testNegativeWeight() {

        QuantityWeight q1 =
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(-1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testZeroWeight() {

        QuantityWeight q1 =
                new QuantityWeight(0.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(0.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }
}