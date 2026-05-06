public class UC9QuantityWeight {

    public static class QuantityWeight {

        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException();

            if (!Double.isFinite(value))
                throw new IllegalArgumentException();

            this.value = value;
            this.unit = unit;
        }

        public QuantityWeight convertTo(WeightUnit targetUnit) {

            if (targetUnit == null)
                throw new IllegalArgumentException();

            double baseValue =
                    unit.convertToBaseUnit(value);

            double converted =
                    targetUnit.convertFromBaseUnit(baseValue);

            return new QuantityWeight(converted, targetUnit);
        }

        public QuantityWeight add(QuantityWeight other) {
            return add(other, this.unit);
        }

        public QuantityWeight add(
                QuantityWeight other,
                WeightUnit targetUnit
        ) {

            if (other == null || targetUnit == null)
                throw new IllegalArgumentException();

            double baseSum =
                    this.unit.convertToBaseUnit(this.value) +
                    other.unit.convertToBaseUnit(other.value);

            double result =
                    targetUnit.convertFromBaseUnit(baseSum);

            return new QuantityWeight(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityWeight other =
                    (QuantityWeight) obj;

            double v1 =
                    this.unit.convertToBaseUnit(this.value);

            double v2 =
                    other.unit.convertToBaseUnit(other.value);

            return Math.abs(v1 - v2) < 1e-6;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        QuantityWeight q1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(q1.equals(q2));

        System.out.println(
                q1.convertTo(WeightUnit.POUND)
        );

        System.out.println(
                q1.add(q2, WeightUnit.GRAM)
        );
    }
}