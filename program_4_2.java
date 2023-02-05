import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class program_4_2 {
    public static void main(String[] args) {
        ArrayDeque<String> myLinkedList = new ArrayDeque<String>();
        Scanner iScanner = new Scanner(System.in, "cp866");
        try {
            enqueue(myLinkedList, iScanner);
            enqueue(myLinkedList, iScanner);
            enqueue(myLinkedList, iScanner);
            dequeue(myLinkedList);
            first(myLinkedList);
            System.out.printf("Refactored list : %s", myLinkedList);
        } finally {
            iScanner.close();
        }

    }

    static ArrayDeque<String> enqueue(ArrayDeque<String> deque, Scanner iScanner) {
        System.out.println("Enter something: ");
        String something = iScanner.next();
        deque.addFirst(something);
        return deque;
    }

    static String dequeue(ArrayDeque<String> deque) {
        System.out.printf("Removed frist element: %s\n", deque.getFirst());
        return deque.removeFirst();
    }

    static String first(ArrayDeque<String> deque) {
        System.out.printf("Frist element now: %s\n", deque.getFirst());
        return deque.getFirst();
    }
}
