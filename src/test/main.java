package test;
import java.util.Scanner;
import java.util.Random;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, num2;
        boolean guess, play = true;

        do{
            Random randomNum = new Random();
            num = 1 + randomNum.nextInt(100);
            do{
                System.out.println("Guess the number between 1 - 100");
                num2 = sc.nextInt();
                if(num == num2){
                    guess = true;                
                } else{
                    if(num2 > num){
                        System.out.println("Too high");
                    } else {
                        System.out.println("Too Low");
                    }
                    guess = false;
                }
            }while (guess == false);
            System.out.println("Congratulations! You guessed right!\nDo you wanna play again?");
            System.out.println("1. Yes\n2. No");
            if(sc.nextInt() == 2){
                play = false;
            }
        }while(play == true);
        
    }
    
}
