import java.util.ArrayList;
import java.util.List;

public class HomeWorkMain {
    public static void main(String[] args) {

//        Box<String> stringBox = new Box<String>();

        Box<Fruit> box = new Box();
        box.putIn(new Orange(2.3));
        box.putIn(new GoldenApple(1));
        box.putIn(new Apple(4));
        System.out.println("Fruit box: ");
        box.getWeight();

        Box<Apple> appleBox = new Box<>();
//        appleBox.putIn(Orange);
        appleBox.putIn(new GoldenApple(4));
        appleBox.putIn(new Apple(7));
        System.out.println("Apple box: ");
        appleBox.getWeight();

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.putIn(new GoldenApple(14));
        goldenAppleBox.putIn(new GoldenApple(11));
//        goldenAppleBox.putIn(new Apple(6));
        System.out.println("Golden apple box: ");
        goldenAppleBox.getWeight();


//        appleBox.moveTo(goldenAppleBox);
        goldenAppleBox.moveTo(appleBox);
        System.out.println("Apple box after adding golden ones: ");
        appleBox.getWeight();

        System.out.println("Golden apple box after removing: ");
        goldenAppleBox.getWeight();

    }

}
