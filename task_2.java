import java.util.ArrayList;

public class task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (int i = 2; i <= 1000; i++) {
            int acc = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    acc++;
                }
            }
            if (acc == 2) {
                myList.add(i);
            }
            acc = 0;
        }
        System.out.printf("Array of prime numbers: %s", myList);
    }
}
