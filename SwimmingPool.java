public class SwimmingPool {

    private final int distance;

    public SwimmingPool(int distance) {
        this.distance = distance;
    }


    public boolean pass(Participant participant) {
        return participant.getSwim() >= distance;
    }
}