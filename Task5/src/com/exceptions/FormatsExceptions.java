package com.exceptions;

import java.io.IOException;

public class FormatsExceptions extends IOException{
    public FormatsExceptions(){}
    
    public FormatsExceptions(String mess){
        super(mess);
    }
}
