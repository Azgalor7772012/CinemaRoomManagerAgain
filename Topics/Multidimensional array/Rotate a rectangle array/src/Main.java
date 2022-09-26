import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int length = scan.nextInt();
        int[][] table = new int[height][length];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = scan.nextInt();
            }
        }
        int[][] result = new int[length][height];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0, k = result[0].length - 1; j < result[0].length; j++, k--) {
                result[i][j] = table[k][i];
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int[] ints : result) {
            ans.append("\n");
            for (int anInt : ints) {
                ans.append(anInt).append(" ");
            }
        }
        System.out.println(ans);

    }

}