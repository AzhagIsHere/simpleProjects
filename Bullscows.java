import java.util.Random;
import java.util.Scanner;

public class Bullscows {
    public String secretCode;
    public int countTurn = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bullscows main = new Bullscows();
        main.generateCode();
        main.playerGuess(sc);
        sc.close();
    }
    public void generateCode(){
        Random rand = new Random();
        secretCode = String.valueOf(rand.nextInt(9000) + 1000);
        System.out.println("The secret code is prepared: ****.");
    }

    public void playerGuess(Scanner sc){
        while(true){
            countTurn++;
            System.out.println("Turn "+countTurn+". Answer: ");
            String guess = sc.nextLine();

            if (guess.length() != 4) {
                System.out.println("Пожалуйста, введите 4-значное число.");
                continue;
            }

            int[] result = compareNumbers(secretCode, guess);
            int bulls = result[0];
            int cows = result[1];

            StringBuilder strokeWithAnswer = new StringBuilder();
            strokeWithAnswer.append("Grade: ");

            if(bulls > 0)
                strokeWithAnswer.append(bulls > 1 ? bulls + " bulls" : bulls + " bull");
            if(cows > 0 && bulls > 0)
                strokeWithAnswer.append(" ");
            if(cows > 0)
                strokeWithAnswer.append(cows > 1 ? cows + " cows" : cows + " cow");

            if(bulls == 0 && cows == 0)
                strokeWithAnswer.append("None");

            strokeWithAnswer.append(".");

            if(bulls == 4){
                System.out.println("Congrats! The secret code is " + secretCode +".");
                break;
            }
            System.out.println(strokeWithAnswer);
        }

    }
    public int[] compareNumbers(String code, String guess){
        int bulls = 0;
        int cows = 0;

        for(int i=0; i<4; i++){
            if(code.charAt(i) == guess.charAt(i)){
                bulls++;
            }
        }

        for(int i=0; i<4; i++){
            if(code.charAt(i) != guess.charAt(i)){
                for(int j=0; j<4; j++){
                    if(code.charAt(j) == guess.charAt(i) && i != j){
                        cows++;
                        break;
                    }
                }
            }
        }
        return new int[]{bulls, cows};

    }

}
