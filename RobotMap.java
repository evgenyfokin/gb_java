import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RobotMap {

    private final int n;
    private final int m;
    private final List<Robot> robots;

    public RobotMap(int n, int m) {
        this.n = n;
        this.m = m;
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) {
        validatePoint(point);
        Robot robot = new Robot(point);
        robots.add(robot);

        return robot;
    }

    /**При успешном поиске элемента по ID метод производит его удаление или бросает ошибку, если ничего не нашел
     */
    public void  removeById(Long id) {
        Optional <Robot> robot = getById(id);
        if (robot.isPresent()) {
            RobotMap.Robot value = robot.get();
            robots.remove(value);
            System.out.println("Робот " + id + " удален.");
        } else {
            throw new IllegalArgumentException("Робот с идентификатором " + id + " не найден");
        }
    }


    public void acceptRobots(Consumer<Robot> robotAcceptor) {
        for (Robot robot : robots) {
            robotAcceptor.accept(robot);
        }
    }

    public Optional<Robot> getById(Long id) {
        for (Robot robot : robots) {
            if (id.equals(robot.id)) {
                return Optional.of(robot);
            }
        }

        return Optional.empty();
    }

    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }

    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    public class Robot {

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private static Long idCounter = 1L;

        public Direction getDirection() {
            return direction;
        }

        public Long getId() {
            return id;
        }

        private final Long id;
        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.id = idCounter++;
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x() - 1, point.y());
                case RIGHT -> new Point(point.x(), point.y() + 1);
                case BOTTOM -> new Point(point.x() + 1, point.y());
                case LEFT -> new Point(point.x(), point.y() - 1);
            };
            validatePoint(newPoint);

            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }

        @Override
        public String toString() {
            return "[" + id + "] " + point.toString() + " [" + direction.name() + "]";
        }
    }

}
