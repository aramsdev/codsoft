package howmanywords;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HowManyWords{

    public static void main(String[] args)throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, parag = 1;
        try{
            System.out.println("Insert text: ");
            String text = BR.readLine();
            if(text.isEmpty() == true){
                count = 0;
            } else {
                String words[] = text.trim().split("\\s+");
                String par[] = text.trim().split("\n");
                count = words.length;
                parag = par.length; 
            }
            System.out.println("Number of words: " + count);
            System.out.println("Paragraphs: " + parag);
        } catch(Exception e){
            System.out.println("Error");
        }
    }
    
}
