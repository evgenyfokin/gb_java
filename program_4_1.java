import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class program_4_1 {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(random.nextInt(10));
        }
        System.out.printf("Original list %s=> ", myLinkedList);
        System.out.printf("Reversed list: %s", reverseArr(myLinkedList));
    }

    static Deque<Integer> reverseArr(LinkedList<Integer> arr) {
        Deque<Integer> dequeInput = new ArrayDeque<Integer>();
        for (Integer i : arr) {
            dequeInput.addFirst(i);
        }
        return dequeInput;
    }

}
