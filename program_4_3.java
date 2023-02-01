import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;;

public class program_4_3 {
    public static void main(String[] args) {
        Deque<Integer> results = new ArrayDeque<Integer>();
        Scanner iScanner = new Scanner(System.in);

        // Methods:
        firstNum(results, iScanner);
        action(results, iScanner);
        action(results, iScanner);
        undo(results);
        action(results, iScanner);

    }

    static Integer firstNum(Deque<Integer> results, Scanner iScanner) {
        if (results.size() == 0) {
            System.out.printf("Enter the first num: ");
            while (!iScanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                iScanner.next();
            }
            int firstNum = iScanner.nextInt();
            results.add(firstNum);
        }
        return null;
    }

    static Integer action(Deque<Integer> results, Scanner iScanner) {
        System.out.printf("Enter the other num: ");
        while (!iScanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            iScanner.next();
        }
        int secondNum = iScanner.nextInt();
        System.out.printf("Enter the operator (+, -, *, /): ");
        String operator = iScanner.next();
        int result = 0;
        switch (operator) {
            case "+":
                result = results.getLast() + secondNum;
                break;
            case "-":
                result = results.getLast() - secondNum;
                break;
            case "*":
                result = results.getLast() * secondNum;
                break;
            case "/":
                result = results.getLast() / secondNum;
                break;
            default:
                System.out.println("There's no such opeartion...");
                return result;
        }
        results.add((int) result);
        System.out.println("Result: " + result);
        System.out.println(results);
        return result;
    }

    static Integer undo(Deque<Integer> results) {
        System.out.println("The last operation will be canseled!");
        return results.removeLast();
    }

}