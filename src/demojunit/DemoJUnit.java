/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Unkno
 */
public class DemoJUnit {

    public DemoJUnit() {
    }

    public int[] decode(String temperature) {
        int[] result;
        int n = temperature.length();
        if (n == 0) {
            result = new int[0];
            return result;
        }
        int i = 0;
        int firstNumber = 0;
        while (i < n && temperature.charAt(i) <= '9' && temperature.charAt(i) >= '0') {
            firstNumber = firstNumber * 10 + temperature.charAt(i) - '0';
            i++;
        }
        
        String symbol = temperature.substring(i);
        result = new int[symbol.length() + 1];
        result[0] = firstNumber;
        for (i = 0; i < symbol.length(); i++) {
            switch (symbol.charAt(i)) {
                case '.':
                    result[i + 1] = result[i];
                    break;
                case '+':
                    result[i + 1] = result[i] + 1;
                    break;
                case '-':
                    result[i + 1] = result[i] - 1;
                    break;
                default:
                    result = new int[0];
                    return result;
            }
        }
        return result;
    }

    public Double findMedian(String temperature) {
        int[] array = decode(temperature);
        
        Double median;
        if (array.length == 0) {
            median = null;
            return median;
        }
        ArrayList<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(list);
        
        int middlePos = (list.size() - 1) / 2;
        if (list.size() % 2 == 0)
            median = (list.get(middlePos) + list.get(middlePos + 1)) / 2.0;
        else 
            median = (double) list.get(middlePos);
        return median;
    }
}

