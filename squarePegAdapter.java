public class squarePegAdapter implements RoundPeg{

    private final double sideLength;

    public squarePegAdapter(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(sideLength, 2) + Math.pow(sideLength, 2));
    }
}