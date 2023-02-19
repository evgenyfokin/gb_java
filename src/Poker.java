public class Poker {

    /** Логика класса полностью взята из готовых решений */
    private final int score;

    public Poker(int score) {
        this.score = score;
    }

    public boolean pass(Participant participant) {
        return participant.getPokerScore() >= score;
    }

}