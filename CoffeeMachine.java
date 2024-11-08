package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int availableWater = 400;
    private int availableMilk = 540;
    private int availableBeans = 120;
    private int availableMoney = 550;
    private int availableCups = 9;
    private int madeCoffeeCups = 0;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner sc = new Scanner(System.in);
        coffeeMachine.action(sc);
        sc.close();
    }

    public void amount() {
        System.out.println("The coffee machine has:");
        System.out.println(availableWater + " ml of water");
        System.out.println(availableMilk + " ml of milk");
        System.out.println(availableBeans + " g of coffee beans");
        System.out.println(availableCups + " disposable cups");
        System.out.println("$" + availableMoney + " of money");
        System.out.println();
    }

    public void action(Scanner sc) {
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit): ");
            String menuChoice = sc.nextLine();
            if (menuChoice.equals("buy")) {
                if (madeCoffeeCups == 10) {
                    System.out.println("I need cleaning!");
                } else {
                    chooseType(sc);
                }
            } else if (menuChoice.equals("fill")) {
                fill(sc);
            } else if (menuChoice.equals("take")) {
                takeMoney();
            } else if (menuChoice.equals("clean")) {
                clean();
            } else if (menuChoice.equals("remaining")) {
                amount();
            } else if (menuChoice.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid action!");
            }
        }
    }

    public void chooseType(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String typeChoice = sc.nextLine();
        System.out.println();

        switch (typeChoice) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private boolean checkResources(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (availableWater < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (availableMilk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (availableBeans < beansNeeded) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        if (availableCups == 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

    public void makeEspresso() {
        int waterForCup = 250;
        int beansForCup = 16;
        int price = 4;

        if (checkResources(waterForCup, 0, beansForCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            availableWater -= waterForCup;
            availableBeans -= beansForCup;
            availableMoney += price;
            availableCups--;
            madeCoffeeCups++;
        }
    }

    public void makeLatte() {
        int waterForCup = 350;
        int milkForCup = 75;
        int beansForCup = 20;
        int price = 7;

        if (checkResources(waterForCup, milkForCup, beansForCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            availableWater -= waterForCup;
            availableMilk -= milkForCup;
            availableBeans -= beansForCup;
            availableMoney += price;
            availableCups--;
            madeCoffeeCups++;
        }
    }

    public void makeCappuccino() {
        int waterForCup = 200;
        int milkForCup = 100;
        int beansForCup = 12;
        int price = 6;

        if (checkResources(waterForCup, milkForCup, beansForCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            availableWater -= waterForCup;
            availableMilk -= milkForCup;
            availableBeans -= beansForCup;
            availableMoney += price;
            availableCups--;
            madeCoffeeCups++;
        }
    }

    public void fill(Scanner sc) {
        System.out.println("Write how many ml of water you want to add: ");
        availableWater += sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many ml of milk you want to add: ");
        availableMilk += sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many ml of coffee you want to add: ");
        availableBeans += sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many disposable cups you want to add: ");
        availableCups += sc.nextInt();
        sc.nextLine();
    }

    public void clean() {
        madeCoffeeCups = 0;
        System.out.println("I have been cleaned!");
    }

    public void takeMoney() {
        System.out.println("I gave you $" + availableMoney);
        availableMoney = 0;
    }
}
