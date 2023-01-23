import java.util.Scanner;;

public class task_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter the 'up to...' num: ");
        while (!iScanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            iScanner.next();
        }
        int userNum = iScanner.nextInt();
        iScanner.close();
        int sumAcc = 0;
        int multAcc = 1;
        for (int i = 1; i <= userNum; i++) {
            sumAcc += i;
            multAcc *= i;
        }
        System.out.printf("The sum of all numbers is: %s,", sumAcc);
        System.out.printf("\n" + "The product of all numbers is: %s.", multAcc);
    }
}