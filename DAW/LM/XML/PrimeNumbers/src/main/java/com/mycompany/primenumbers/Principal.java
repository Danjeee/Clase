
package com.mycompany.primenumbers;


public class Principal {
    public static void main(String[] args){
        PrimeNumber primeTest = new PrimeNumber(27);
        if(!primeTest.isPrime()){
            System.out.println("NO es primo");
        }
        else {
            System.out.println("Es primo.");
        }
    }
}