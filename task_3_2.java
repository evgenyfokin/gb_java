import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_3_2 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<Integer>(20);

        for (int i = 0; i < random.nextInt(5, 20); i++) {
            numbers.add(random.nextInt(100));
        }
        System.out.printf("Original list: %s=> ", numbers);

        int max_num = 0;
        for (Integer num : numbers) {
            if (num > max_num) {
                max_num = num;
            }
        }
        System.out.printf("The biigest num: %s", max_num);
    }
}
