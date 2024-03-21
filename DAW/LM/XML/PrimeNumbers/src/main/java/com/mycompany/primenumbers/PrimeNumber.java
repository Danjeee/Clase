
package com.mycompany.primenumbers;

public class PrimeNumber {
    private int value;
    
    public PrimeNumber(int myvalue){
        value = myvalue;
    }
    
    public boolean isPrime(){
        if(value <= 0){
            throw new IllegalArgumentException();
        }
        
        if(value == 1){
            return false;
        }

        if(value == 2 || value == 3){
            return true;
        }

        int i = 2;
        while(i <= Math.ceil(Math.sqrt(value))){
            if(value % i == 0){
                return false;
            }
            i++;
        }
        
        return true;
    }
}
