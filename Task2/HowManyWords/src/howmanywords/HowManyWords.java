package howmanywords;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HowManyWords{

    public static void main(String[] args)throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try{
            System.out.println("Insert text: ");
            String text = BR.readLine();
            for(int i = 0; i < text.length(); i++){
                char res = text.charAt(i);
                if(res == ' ' || res == '.'){
                    count++;
                }
                if(i == (text.length()-1) && res != '.'){
                    count++;
                }
            }
            System.out.println("Number of words: " + count);
        } catch(Exception e){
            System.out.println("Error");
        }
    }
    
}
