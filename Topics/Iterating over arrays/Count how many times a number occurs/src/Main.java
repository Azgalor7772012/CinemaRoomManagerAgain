import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }

        int reference = scan.nextInt();

        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == reference) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}