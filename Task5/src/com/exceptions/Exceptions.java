package com.exceptions;

import java.io.IOException;

public class Exceptions extends IOException{
    public Exceptions(){}
    
    public Exceptions (String mess){
        super(mess);
    }
}
