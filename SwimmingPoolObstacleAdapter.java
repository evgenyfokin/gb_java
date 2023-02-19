public class SwimmingPoolObstacleAdapter implements Obstacle{

    private final SwimmingPool swimmingPool;

    public SwimmingPoolObstacleAdapter(SwimmingPool swimmingPool) {
        this.swimmingPool = swimmingPool;


    }

    @Override
    public boolean pass(Participant participant) {
        return swimmingPool.pass(participant);
    }
}