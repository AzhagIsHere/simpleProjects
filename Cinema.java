package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    int rows;
    int seats;
    int rowNumber;
    int seatNumber;
    char[][] cinemaMatrix;
    int[][] ticketPriceMatrix;
    int countPurchesadTickets = 0;
    double percent = 0.00;
    int currentIncome = 0;
    int totalIncome = 0;
    int totalSeats = 0;

    public static void main(String[] args) {
        // Write your code here
        Cinema cinema = new Cinema();
        Scanner sc = new Scanner(System.in);

        cinema.start(sc);
        cinema.menu(sc);
    }

    public void start(Scanner sc) {

        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();
        totalSeats = rows * seats;

       cinemaMatrix = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaMatrix[i][j] = 'S';
            }
        }
        ticketPriceMatrix = new int[rows][seats];
        if(rows*seats < 60){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < seats; j++) {
                    ticketPriceMatrix[i][j] = 10;
                    totalIncome += 10;
                }
            }
        } else {
            if(rows % 2 == 0){
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < seats; j++) {
                        if( i < rows / 2){
                            ticketPriceMatrix[i][j] = 10;
                            totalIncome += 10;
                        }else{
                            ticketPriceMatrix[i][j] = 8;
                            totalIncome += 8;
                            }
                        }
                }
            } else {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < seats; j++) {
                        if( i < rows / 2){
                            ticketPriceMatrix[i][j] = 10;
                            totalIncome += 10;
                        }else{
                            ticketPriceMatrix[i][j] = 8;
                            totalIncome += 8;
                        }
                    }
                }

            }
        }


    }
    public void menu(Scanner sc) {
        int menuChoice;
        while(true){
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("4. Exit");
            menuChoice = sc.nextInt();
            if(menuChoice == 1){
                this.printMatrix();
            } else if(menuChoice == 2){
                this.choosePlace(sc);
            } else if(menuChoice == 3){
                this.statistics();
            }else {
                break;
            }
        }
    }


    public void printMatrix(){

        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 1; i <= seats; i++){
            if(i == seats){
                System.out.println(" "+i);
            }else {
                System.out.print(" "+i);
            }
        }

        for (int i = 0; i < rows; i++){
            System.out.print(i+1);
            for (int j = 0; j < seats; j++){
                System.out.print(" " + cinemaMatrix[i][j]);
            }
            System.out.println();
        }

    }

    public void choosePlace(Scanner sc) {

        while(true){
            System.out.println("Enter a row number:");
            rowNumber = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = sc.nextInt();
            if ( rowNumber > rows || seatNumber > seats || rowNumber < 0 || seatNumber < 0 ) {
                System.out.println("Wrong input");
            } else if (cinemaMatrix[rowNumber-1][seatNumber-1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                cinemaMatrix[rowNumber-1][seatNumber-1] = 'B';
                break;
            }
        }

        countPurchesadTickets++;
        percent = (countPurchesadTickets * 100.0) / totalSeats;
        printTicketPrice();
    }


    public void printTicketPrice(){
        System.out.println("Ticket price: " + "$" + ticketPriceMatrix[rowNumber-1][seatNumber-1]);
        currentIncome += ticketPriceMatrix[rowNumber-1][seatNumber-1];
    }

    public void statistics(){
        System.out.println("Number of purchased tickets: " + countPurchesadTickets);
        String formattedPercentage = String.format("%.2f", percent);
        System.out.println("Percentage: " + formattedPercentage + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}
