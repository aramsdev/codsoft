package com.exceptions;
import java.io.IOException;

public class studentException extends IOException{
    public studentException (){}
    
    public studentException(String mess){
        super(mess);
    }
}
