import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_3_1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<Integer>(20);
        List<Integer> odds = new ArrayList<Integer>(20);

        for (int i = 0; i < random.nextInt(5, 20); i++) {
            numbers.add(random.nextInt(100));
        }
        System.out.printf("Original list: %s=> ", numbers);
        for (Integer num : numbers) {
            if (num % 2 != 0 && num != 0) {
                odds.add(num);
            }
        }
        System.out.printf("Refactored list: %s", odds);
    }
}
