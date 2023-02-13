package ru.gb.lesson1.game;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {

    private final int n;
    private final int m;
    private final int length;

    private List<Robot> robots;

    /**
     * 
     * @param length задается в клиентском коде и является ограничивающим значением
     *               при проверке длинны массива с роботами
     */
    public RobotMap(int n, int m, int length) {
        validateMap(n, m);
        this.n = n;
        this.m = m;
        this.length = length;
        this.robots = new ArrayList<>();
    }

    /** Метод "RobotMap" с заданным параметром колличества роботов */
    public RobotMap(int n, int m) {
        this(n, m, 5);
        validateMap(n, m);
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) {
        validatePoint(point);
        Robot robot = new Robot(point);
        robots.add(robot);
        validateAmount(robots, length);

        return robot;
    }

    /**
     * 
     * @param arr    - массив с роботами
     * @param length - значение максимальной длинны массива, контролируещее
     *               колличество роботов
     */
    private void validateAmount(List<Robot> arr, int length) {
        if (arr.size() > length) {
            throw new IllegalStateException("Вы не можете использовать больше " + length + " роботов!");
        }
    }

    /** Валидация ввода неотрицательных значений игрового поля */
    private void validateMap(int n, int m) {
        if (n < 0 || m < 0) {
            throw new IllegalStateException("Координаты поля не могут быть отрицательными!");
        }
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

        private Direction direction;
        private Point point;

        public Robot(Point point) {
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

        /**
         * 
         * @param steps - задается в качестве аргумента метода "move" в клиентском коде
         *              и выполняет роль финального значения счетчика, итерирующего
         *              колличество вызовов метода "move" без
         *              параметров
         */
        public void move(int steps) {
            int i = 0;
            while (i < steps) {
                move();
                i++;
            }
        }

        @Override
        public String toString() {
            return point.toString() + ", [" + direction.name() + "]";
        }
    }

}
