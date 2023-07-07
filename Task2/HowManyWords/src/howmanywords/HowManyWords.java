package howmanywords;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import domain.*;

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
    public static void file(){
        file file = new file();
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        boolean err;
        String exist = "", namef;
        do{
            try{
                err = false;
                System.out.println("Do you already have a file? (yes/no)");
                exist = BR.readLine();
                if(!exist.equals("yes") && !exist.equals("no")) throw new fileexists("You have to write yes or no");
            } catch (fileexists e){
                System.out.println("You have to write yes or no");
                err = true;
            } catch (IOException e){
                System.out.println("There was an error");
                err = true;
            }
        }while(err == true);
        try{
            if(exist.equals("yes")){
                System.out.println("Whats the name of the file?");
                namef = BR.readLine();
                file.read(namef);
            } else{
                System.out.println("What's the name you want for the file?");
                namef = BR.readLine();
                file.write(namef);
            }
        } catch (Exception e){
            System.out.println("There was an error opening the file");
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, parag = 1, op;
        do{
            System.out.println("Options: ");
            System.out.println("1. Count words in a file");
            System.out.println("2. Count words in a inserted text");
            System.out.println("9. Exit program");
            op = Integer.parseInt(BR.readLine());
            
            switch(op){
                case 1:
                file();
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
