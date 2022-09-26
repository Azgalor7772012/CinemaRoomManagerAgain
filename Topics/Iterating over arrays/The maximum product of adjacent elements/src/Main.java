import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int adjacentValues =  arr[i] * arr[i + 1];
            if (max < adjacentValues) {
                max = adjacentValues;
            }
        }
        System.out.println(max);
    }
}