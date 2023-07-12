package domain;
import java.io.IOException;

public class noNulls extends IOException{
    public noNulls(){
    }
    public noNulls(String mess){
        super(mess);
    }
}
