import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int count = 0;
        for (int i = 1; count < amount; i++) {
            int j = i;
            while (j > 0 && count < amount) {
                System.out.print(i + " ");
                count++;
                j--;
            }
        }
    }
}