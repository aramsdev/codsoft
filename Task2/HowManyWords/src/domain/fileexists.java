package domain;
import java.io.IOException;

public class fileexists extends IOException{
    public fileexists(){}
    public fileexists(String message){
        super(message);
    }
}
