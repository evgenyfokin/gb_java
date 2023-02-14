import java.util.Arrays;
import java.util.Random;

public class program_5_3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        sort(left);
        sort(right);
        merge(arr, left, right, left.length, right.length);
    }

    private static void merge(int[] arr, int[] left, int[] right, int leftLength, int rightLength) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
                k++;
            } else {
                arr[k] = right[j++];
                k++;
            }
        }
        while (i < leftLength) {
            arr[k] = left[i++];
            k++;
        }
        while (j < rightLength) {
            arr[k] = right[j++];
            k++;
        }
    }
}
