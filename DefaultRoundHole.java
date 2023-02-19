public class DefaultRoundHole implements RoundHole {

    private final double radius;

    DefaultRoundHole(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }

}
