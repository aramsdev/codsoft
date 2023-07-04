package test;
import java.util.Scanner;
import java.util.Random;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, num2, attempts = 7, win=0, loss=0;
        boolean guess, play = true;
           
        System.out.println("-------------\n  YOU vs AI  \n-------------\n   " + win + "  |  " + loss + "\n-------------");
        do{
            Random randomNum = new Random();
            num = 1 + randomNum.nextInt(100);
            for(int i = 0; i < attempts; i++){
                System.out.println("Guess the number between 1 - 100");
                num2 = sc.nextInt();
                if(num == num2){
                    System.out.println("Congratulations! You guessed right!");
                    win++;
                    break;
                } else if(i == 6){
                    System.out.println("You have no attempts left! It was " + num);
                    loss++;
                    break;
                }else{
                    if(num2 > num){
                        System.out.println("Too high");
                    } else {
                        System.out.println("Too Low");
                    }
                    System.out.println("You have " + (attempts - (i+1)) + " attempt(s) left");
                }
            }
            System.out.println("-------------\n  YOU vs AI  \n-------------\n   " + win + "  |  " + loss + "\n-------------");
            System.out.println("Do you wanna play again?");
            System.out.println("1. Yes\n2. No");
            if(sc.nextInt() == 2){
                play = false;
            }
        }while(play == true);
        
    }
    
}