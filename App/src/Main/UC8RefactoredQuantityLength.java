public class UC8RefactoredQuantityLength {

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException();

            if (!Double.isFinite(value))
                throw new IllegalArgumentException();

            this.value = value;
            this.unit = unit;
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {

            if (targetUnit == null)
                throw new IllegalArgumentException();

            double baseValue =
                    unit.convertToBaseUnit(value);

            double converted =
                    targetUnit.convertFromBaseUnit(baseValue);

            return new QuantityLength(converted, targetUnit);
        }

        public QuantityLength add(
                QuantityLength other,
                LengthUnit targetUnit
        ) {

            if (other == null || targetUnit == null)
                throw new IllegalArgumentException();

            double baseSum =
                    this.unit.convertToBaseUnit(this.value) +
                    other.unit.convertToBaseUnit(other.value);

            double result =
                    targetUnit.convertFromBaseUnit(baseSum);

            return new QuantityLength(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other =
                    (QuantityLength) obj;

            double v1 =
                    this.unit.convertToBaseUnit(this.value);

            double v2 =
                    other.unit.convertToBaseUnit(other.value);

            return Math.abs(v1 - v2) < 1e-6;
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(q1.equals(q2));

        System.out.println(
                q1.convertTo(LengthUnit.INCH)
        );

        System.out.println(
                q1.add(q2, LengthUnit.YARD)
        );
    }
} {
    
}
