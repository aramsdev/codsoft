package domain;
import java.io.IOException;
public class numbersException extends IOException{
    public numbersException(){     
    }
    public numbersException(String mess){
        super(mess);
    }
}
