package com.two;

import java.util.Arrays;

/**
 * Created by TangXW on 2017/6/27.
 */


public class PrimeTest2 {
    public static void main(String[] args) {

        int n = 20;

        int[] array = new int[n];

        for (int i = 2; i < n; i++) {

            array[i] = i;

        }
        for (int i = 2; i < n; i++) {
            if (array[i] != 0) {

                int j, temp;

                temp = array[i];

                for (j = 2 * temp; j < n; j = j + temp) {
                    array[j] = 0;
                }
                System.out.println("\n");

            }

        }

    }

}