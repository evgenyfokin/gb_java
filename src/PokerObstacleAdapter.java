public class PokerObstacleAdapter implements Obstacle {

    /** Логика полностью аналогична уже написанным адаптерам препятствий */
    private final Poker poker;

    public PokerObstacleAdapter(Poker poker) {
        this.poker = poker;
    }

    @Override
    public boolean pass(Participant participant) {
        return poker.pass(participant);
    }
}