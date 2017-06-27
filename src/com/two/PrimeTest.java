package com.two;

/**
 * Created by TangXW on 2017/6/27.
 */
public class PrimeTest {
    public static boolean isPrime(int num){
        for(int i = 2; i < (num - 1); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(int j = 2; j <= 20; j++){
            if(isPrime(j)){
                System.out.println("is Prime:" + j);
            }
        }
    }
}
