public class RoundHoleMachine {
    public RoundHole makeHole(RoundPeg peg) {
        double radius = peg.getRadius();
        return new DefaultRoundHole(radius);
    }
}