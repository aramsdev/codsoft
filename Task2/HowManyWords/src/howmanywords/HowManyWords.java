package howmanywords;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import domain.file;

public class HowManyWords{
    
    public static void count(){
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try{
            System.out.println("Insert text: ");
            String text = BR.readLine();
            if(text.isEmpty() == true){
                count = 0;
            } else {
                String words[] = text.trim().split("[\\s+]");
                count = words.length;
            }
            System.out.println("Number of words: " + count);
        } catch(Exception e){
            System.out.println("Error");
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        file file = new file();
        int count = 0, parag = 1, op;
        do{
            System.out.println("Options: ");
            System.out.println("1. Count words in a file");
            System.out.println("2. Count words in a inserted text");
            System.out.println("9. Exit program");
            op = Integer.parseInt(BR.readLine());
            
            switch(op){
                case 1:
                    break;
                case 2:
                    count();
                    break;
                default:
                    System.out.println("Choose a valid option");
                    break;
                case 9: 
                    System.out.println("Thanks for using the program");
                    break;
            }
            System.out.println("");
        }while(op != 9);        
    }
    
}
