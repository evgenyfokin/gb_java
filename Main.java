public class Main {
    public static void main(String[] args) {

        RoundPeg peg = new DefaultRoundPeg(2.5); // создаем объект RoundPeg с радиусом 2.5
        RoundHoleMachine machine = new RoundHoleMachine();
        RoundHole hole = machine.makeHole(peg); // создаем объект RoundHole с радиусом 2.5
        System.out.println("Peg radius: " + peg.getRadius());
        System.out.println("Hole diameter: " + hole.getRadius() * 2);

        RoundPeg squarePeg = new squarePegAdapter(4.2);
        RoundHole newHole = machine.makeHole(squarePeg);
        System.out.println("Hole radius for square peg: " + newHole.getRadius());

    }
}