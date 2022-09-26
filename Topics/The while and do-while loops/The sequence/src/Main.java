import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int max = 0;
        while (scanner.hasNextInt()) {
            int newDig = scanner.nextInt();
            if (newDig > max && newDig % 4 == 0) {
                max = newDig;
            }
        }
        System.out.println(max);
    }
}