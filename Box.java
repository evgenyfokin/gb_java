import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void putIn(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        System.out.println(weight);
        return weight;
    }

    public void moveTo(Box<? super T> anotherBox) {
        for (T fruit : fruits) {
            anotherBox.putIn(fruit);
        }
        fruits = new ArrayList<>();
    }

}
