import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int outer = scan.nextInt();
        int inner = scan.nextInt();
        int[][] table = new int[outer][inner];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = scan.nextInt();
            }
        }

        int reference = scan.nextInt();
        int counter = 0;
        String ans = "0";
        for (int i = 0; i < table.length; i++) {
            if (counter == reference) {
                break;
            }
            counter = 0;

            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] != 1) {
                    counter++;
                } else if (table[i][j] == 1) {
                    counter = 0;
                }
                if (counter == reference) {
                    ans = String.valueOf(i + 1);
                    break;
                }
            }
        }

        System.out.println(ans);


    }
}