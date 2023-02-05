import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_3_3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<Integer>(20);

        for (int i = 0; i < random.nextInt(5, 20); i++) {
            numbers.add(random.nextInt(100));
        }
        System.out.printf("Original list: %s=> ", numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - i - 1; j++) {
                int temp = 0;
                if (numbers.get(j) > numbers.get(j + 1)) {
                    temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted list: " + numbers);
    }
}
