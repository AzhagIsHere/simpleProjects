package machine;

import java.util.Scanner;

public class CoffeeMachine {

    int availableWater = 400;
    int availableMilk = 540;
    int availableBeans = 120;
    int availableMoney = 550;
    int availableCups = 9;


    int madeCoffeeCups = 0;


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
        System.out.println("$"+availableMoney + " of money");
        System.out.println();
    }

    public void action(Scanner sc) {
        while(true){
            System.out.println("Write action (buy, fill, take, clean, remaining, exit): ");
            String menuChoice = sc.nextLine();
            if(menuChoice.equals("buy")){

                if(madeCoffeeCups == 10){
                    System.out.println("I need cleaning!");
                }else{
                    this.chooseType(sc);
                }

            } else if(menuChoice.equals("fill")){
                this.fill(sc);
            } else if(menuChoice.equals("take")){
                this.takeMoney();
            } else if(menuChoice.equals("clean")){
                this.clean();
            }else if(menuChoice.equals("remaining")){
                amount();
            } else if(menuChoice.equals("exit")){
                break;
            }else {
                break;
            }
        }
    }

    public void chooseType(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String typeChoice = sc.nextLine();
        System.out.println();

        if(typeChoice.equals("1")){
            this.makeEspresso();
        } else if(typeChoice.equals("2")){
            this.makeLatte();
        } else if(typeChoice.equals("3")){
            this.makeCappuccino();
        } else if(typeChoice.equals("back")){
            return;
        }
    }

    public void makeEspresso() {
        int waterForCup = 250;
        int beansForCup = 16;
        int price = 4;

        if(availableWater < waterForCup) {
            System.out.println("Sorry, not enough water!");
        } else if(availableBeans < beansForCup) {
            System.out.println("Sorry, not enough beans!");
        } else if (availableCups == 0){
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.availableWater -= waterForCup;
            this.availableBeans -= beansForCup;
            this.availableMoney += price;
            this.availableCups--;
            this.madeCoffeeCups++;
        }

    }

    public void makeLatte() {
        int waterForCup = 350;
        int milkForCup = 75;
        int beansForCup = 20;
        int price = 7;

        if(availableWater < waterForCup) {
            System.out.println("Sorry, not enough water!");
        } else if(availableMilk < milkForCup) {
            System.out.println("Sorry, not enough beans!");
        } else if(availableBeans < beansForCup) {
            System.out.println("Sorry, not enough beans!");
        } else if (availableCups == 0){
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.availableWater -= waterForCup;
            this.availableMilk -= milkForCup;
            this.availableBeans -= beansForCup;
            this.availableMoney += price;
            this.availableCups--;
            this.madeCoffeeCups++;
        }
    }

    public void makeCappuccino() {
        int waterForCup = 200;
        int milkForCup = 100;
        int beansForCup = 12;
        int price = 6;

        if(availableWater < waterForCup) {
            System.out.println("Sorry, not enough water!");
        } else if(availableMilk < milkForCup) {
            System.out.println("Sorry, not enough beans!");
        } else if(availableBeans < beansForCup) {
            System.out.println("Sorry, not enough beans!");
        } else if (availableCups == 0){
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.availableWater -= waterForCup;
            this.availableMilk -= milkForCup;
            this.availableBeans -= beansForCup;
            this.availableMoney += price;
            this.availableCups--;
            this.madeCoffeeCups++;
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

    public void clean(){
        madeCoffeeCups = 0;
        System.out.println("I have been cleaned!");
    }

    public void takeMoney() {
        System.out.println("I gave you $" + availableMoney);
        availableMoney = 0;
    }


//    public void makeCoffee(Scanner sc) {
//        System.out.println("Write how many cups of coffee you will need:");
//        coffeeCups = sc.nextInt();
//        int maxCupsByWater = availableWater / waterPerCup;
//        int maxCupsByMilk = availableMilk / milkPerCup;
//        int maxCupsByBeans = availableBeans / beansPerCup;
//
//        int maxCups = Math.min(maxCupsByWater, Math.min(maxCupsByMilk, maxCupsByBeans));
//
//        if (maxCups >= coffeeCups) {
//            if (maxCups > coffeeCups) {
//                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - coffeeCups) + " more than that)");
//            } else {
//                System.out.println("Yes, I can make that amount of coffee");
//            }
//        } else {
//            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
//        }
//    }


}
