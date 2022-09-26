package cinema;

import java.util.Scanner;

public class Cinema {
    static int currentIncome = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Просим кол-во рядом и мест
        System.out.println("Enter the number of rows:");
        int numberOfRows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scan.nextInt();
        //Инициализируем зал
        char[][] table = new char[numberOfRows][numberOfSeats];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 'S';
            }
        }

        //Меню
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int choice = scan.nextInt();
            if (choice == 0) {
                break;
            }

            switch(choice) {
                case 1:
                    tablePrinter(numberOfSeats, table);
                    break;
                case 2:
                    secondChoice(table, numberOfRows, numberOfSeats);
                    break;
                case 3:
                    printStatistic(table, numberOfRows, numberOfSeats);
                    break;
            }
        }


    }


    // Печатаем зал
    static void tablePrinter(int numberOfSeats, char[][] table) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= numberOfSeats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Изменяем зал
    static void tableModifierPrinter(int currentRow, int currentSeat, char[][] table) {
        table[currentRow - 1][currentSeat - 1] = 'B';

    }

    static void priceCalculator(int currentRow, int numberOfRows, int numberOfSeats) {
        int ticketPrice = 0;
        if (numberOfRows * numberOfSeats < 60) {
            ticketPrice = 10;
        } else if (currentRow % 2 != 0) {
            if (currentRow < Math.ceil((double) numberOfRows / 2)) {
                ticketPrice = 10;

            } else {
                ticketPrice = 8;
            }
        } else {
            if (currentRow > numberOfRows / 2) {
                ticketPrice = 8;
            } else {
                ticketPrice = 10;
            }
        }
        System.out.println("Ticket price: " + "$" + ticketPrice + "\n");
        //Прибавляем стоимость билета к общему заработку
        currentIncome += ticketPrice;

    }

    static void printStatistic(char[][] table, int numberOfRows, int numberOfSeats) {
        int currentSoldTickets = boughtTickets(table);
        double currentSoldTicketsInPercents = (double) currentSoldTickets * 100 / (numberOfRows * numberOfSeats);
        int totalIncome = allTicketsSold(table, numberOfRows, numberOfSeats);

        //Печатаем
        System.out.printf("Number of purchased tickets: %d\n", currentSoldTickets);
        System.out.printf("Percentage: %.2f", currentSoldTicketsInPercents);
        System.out.println("%");
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);

    }
    //Проверяет сколько билетов уже куплено
    static int boughtTickets(char[][] table) {
        int currentTickets = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'B') {
                    currentTickets += 1;
                }
            }
        }
        return currentTickets;
    }

    static int allTicketsSold(char[][] table, int numberOfRows, int numberOfSeats) {
        int income = 0;
        if (numberOfRows * numberOfSeats < 60) {
            income = numberOfRows * numberOfSeats * 10;
        } else if (numberOfRows % 2 != 0) {
          income =  numberOfRows / 2 * numberOfSeats * 10 +  (int) Math.ceil((double) numberOfRows / 2) * numberOfSeats * 8 ;
        } else {
            income = numberOfRows / 2 * 8 + numberOfRows / 2 * 10;
        }
        return income;
    }

    static void secondChoice(char[][] table, int numberOfRows, int numberOfSeats) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            //Просим какое место хотят купить
            System.out.println("Enter a row number:");
            int currentRow = scan.nextInt() ;
            System.out.println("Enter a seat number in that row:");
            int currentSeat = scan.nextInt();
            try {
                if (table[currentRow - 1][currentSeat - 1] != 'B') {
                    //Меняем зал в соответствии с выбранным билетом
                    tableModifierPrinter(currentRow, currentSeat, table);
                    //Печатаем цену
                    priceCalculator(currentRow, numberOfRows, numberOfSeats);
                    break;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            }catch (Exception e) {
                System.out.println("Wrong input!");
            }
        }
    }
}