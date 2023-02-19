public abstract class BaseParticipant implements Participant {

    private final String name;
    private final int jump;
    private final int run;
    private final int swim;
    private final int poker;

    public BaseParticipant (String name, int jump, int run, int swim, int poker) {
        this.name = name;
        this.jump = jump;
        this.run = run;
        this.swim = swim;
        this.poker = poker;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRun() {
        return jump;
    }

    @Override
    public int getJump() {
        return run;
    }

    @Override
    public int getSwim() {
        return swim;
    }

    @Override
    public int getPokerScore() {
        return poker;
    }
}