import java.util.Scanner;;

public class task_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter the first num: ");
        while (!iScanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            iScanner.next();
        }
        double firstNum = iScanner.nextInt();
        System.out.printf("Enter the second num: ");
        while (!iScanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            iScanner.next();
        }
        double secondNum = iScanner.nextInt();
        System.out.printf("Enter the operator (+, -, *, /): ");
        String operator = iScanner.next();
        iScanner.close();
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
            default:
                System.out.println("There's no such opeartion...");
                return;
        }
        System.out.println("Result: " + result);
    }
}
