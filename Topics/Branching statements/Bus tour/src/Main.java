import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int amountOfBridges = scanner.nextInt();
        int counter = 1;
        boolean crashFlag = false;
        while (counter <= amountOfBridges) {
            int bridgesHeight = scanner.nextInt();
            if (busHeight >= bridgesHeight) {
                System.out.println("Will crash on bridge " + counter);
                crashFlag = true;
                break;
            }
            counter++;
        }
        if (!crashFlag) {
            System.out.println("Will not crash");
        }
    }
}