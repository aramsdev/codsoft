package test;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import domain.numbersException;
import java.util.InputMismatchException;

public class main {

    public static void main(String[] args) throws Exception, numbersException, InputMismatchException{
        Scanner sc = new Scanner(System.in);
        int num, num2, attempts = 7, win=0, loss=0, op;
        boolean guess, play = true, err;
           
        System.out.println("----------------\n YOU   vs   ARS  \n----------------\n  " + win + "    |     " + loss + "\n----------------");
            do{
                try{
                Random randomNum = new Random();
                num = 1 + randomNum.nextInt(100);
                    for(int i = 0; i < attempts; i++){
                            System.out.println("Guess the whole number between 1 - 100");
                            num2 = sc.nextInt();
                            if(num2 < 1 || num2 > 100) throw new numbersException("Error: The number has to be between 1-100");
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
                } catch(InputMismatchException ex){
                    sc.next();
                    System.out.println("Error: You have to enter a number between 1-100. The game will restart.");
                } catch (numbersException e){
                    System.out.println("Error: The number has to be between 1-100. The game will restart.");
                }
                do{
                    try{
                        err = false;
                        System.out.println("----------------\n YOU   vs   ARS  \n----------------\n  " + win + "    |     " + loss + "\n----------------");
                        System.out.println("Do you wanna play again?");
                        System.out.println("1. Yes\n2. No");
                        op = sc.nextInt();
                        if(op == 2){
                            play = false;
                        }
                        if(op != 1 && op != 2) throw new numbersException("Error: The only options available are 1 or 2");
                    } catch(InputMismatchException ex){
                        sc.next();
                        System.out.println("Error: The only options available are 1 or 2.");
                        err = true;
                    } catch (numbersException e){
                        System.out.println("Error: The only options available are 1 or 2.");
                        err = true;
                    }                
                } while(err == true);
            }while(play == true);   
    }
    
}