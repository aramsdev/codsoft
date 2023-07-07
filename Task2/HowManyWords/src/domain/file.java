package domain;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class file{
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    public int write(String name) throws Exception{
        DataOutputStream DOS = null;
        String text;
        
        try{
            DOS = new DataOutputStream(new FileOutputStream(name, true));
        } catch(IOException e){
            System.out.println("Error in creating/opening the file");
            return 0;
        }
        
        try{
            do{
                System.out.println("Insert the text you wanna have in the file. ['exit' to end text]");
                text = BR.readLine();
                if(text.equals("exit")){
                    break;
                } else {
                    DOS.writeUTF(text);
                }
            } while(!text.equals("exit"));
        } catch(Exception e){
            
        }
        DOS.close();
        return 0;
    }
    public int read(String name) throws Exception{
        DataInputStream DIS = null;
        String words[] = null;
        int count = 0;

        try{
            DIS = new DataInputStream(new FileInputStream(name));
        } catch(FileNotFoundException e){
            System.out.println("Error opening the file");
        }
        
        try{
            while(DIS.available() != 0){
                words = DIS.readUTF().split("\\s+");
                count = count + words.length;
            }
        }catch(Exception e){
            System.out.println("There was an error");
        }
        DIS.close();
        System.out.println("NUmber of words: " + count);
        return 0;
    }
}
