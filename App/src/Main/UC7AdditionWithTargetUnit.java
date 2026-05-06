package com.apps.quantitymeasurement;

public class UC7AdditionWithTargetUnit {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.393701 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double value) {
            return value / toFeet;
        }
    }

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        public QuantityLength add(QuantityLength other) {
            return add(other, this.unit);
        }

        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

            if (other == null || targetUnit == null)
                throw new IllegalArgumentException();

            if (!Double.isFinite(value) || !Double.isFinite(other.value))
                throw new IllegalArgumentException();

            double sumFeet =
                    this.unit.toFeet(this.value) +
                    other.unit.toFeet(other.value);

            double result = targetUnit.fromFeet(sumFeet);

            return new QuantityLength(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            double v1 = this.unit.toFeet(this.value);
            double v2 = other.unit.toFeet(other.value);

            return Math.abs(v1 - v2) < 1e-6;
        }
    }

    public static void main(String[] args) {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result =
                a.add(b, LengthUnit.YARD);

        System.out.println(result.value);
    }
}