package com.apps.quantitymeasurement;

public class UC6LengthAddition {

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
            if (other == null || unit == null || other.unit == null)
                throw new IllegalArgumentException();

            if (!Double.isFinite(value) || !Double.isFinite(other.value))
                throw new IllegalArgumentException();

            double sumFeet = unit.toFeet(value) + other.unit.toFeet(other.value);

            double result = unit.fromFeet(sumFeet);

            return new QuantityLength(result, unit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            double v1 = unit.toFeet(value);
            double v2 = other.unit.toFeet(other.value);

            return Double.compare(v1, v2) == 0;
        }
    }

    public static void main(String[] args) {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(a.add(b).equals(new QuantityLength(2.0, LengthUnit.FEET)));
    }
}