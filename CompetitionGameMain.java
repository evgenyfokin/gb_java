import java.util.Random;

public class CompetitionGameMain {
    static Random random = new Random();

    public static void main(String[] args) {
        Obstacle[] obstacles = createObstacles();
        Participant[] participants = createParticipants();
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                boolean result = obstacle.pass(participant);
                if (result) {
                    System.out.println("Участник #" + participant.getName() + " преодолел препятствие");
                } else {
                    System.out.println("Участник #" + participant.getName() + " не преодолел препятствие");
                }
            }
        }
    }

    private static Obstacle[] createObstacles() {
        return new Obstacle[] {
                new RoadObstacleAdapter(new Road(100)),
                new RoadObstacleAdapter(new Road(45)),
                new SwimmingPoolObstacleAdapter(new SwimmingPool(20)),
                new WallObstacleAdapter(new Wall(40)),
                /** Играют "All in" скор генерируется рандомно */
                new PokerObstacleAdapter(new Poker(random.nextInt(100)))
        };
    }

    private static Participant[] createParticipants() {
        return new Participant[] {
                new StandartParticipant("Igor", 50, 30, 20, random.nextInt(100)),
                new Cat("cat", 60, 25, random.nextInt(100)),
                new Cheater("Cheater"),

        };
    }
}