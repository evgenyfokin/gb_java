public enum Direction {
    TOP, RIGHT, BOTTOM, LEFT;

    /**Заменил null на ошибку аргумента
     */
    public static Direction ofString(String str) {
        Direction[] values = values();
        for (Direction value : values) {
            if (str.equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException(str + " - неверное направление");
    }
}
