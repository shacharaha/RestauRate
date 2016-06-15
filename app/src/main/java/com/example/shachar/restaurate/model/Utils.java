package com.example.shachar.restaurate.model;

/**
 * Created by Shachar on 6/12/2016.
 */
public class Utils {
    public static double getAverage(double[] inputArray) {
        double average = 0;
        for (int i = 0 ; i < inputArray.length; i++) {
            average += inputArray[i];
        }
        average = average / inputArray.length;
        return  average;
    }
}
