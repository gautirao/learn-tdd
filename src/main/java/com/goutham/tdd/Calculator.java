package com.goutham.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public static int add(String string) {
    if(!string.isEmpty()){
        List<Integer> numbers = stringArrToIntList(getSplit(string));
            checkForNegatives(numbers);
        return numbers.stream().reduce(Integer::sum).orElseThrow();
    }
        return 0;
    }

    private static void checkForNegatives(List<Integer> numbers) {
    StringBuilder sbuilder = new StringBuilder();
       numbers.stream().filter(num -> num < 0).forEach(num -> sbuilder.append(num).append(" "));
       if(!sbuilder.toString().isEmpty()){
           throw new RuntimeException("Negatives not allowed "+ sbuilder.toString());
       }

    }

    private static List<Integer> stringArrToIntList(String[] strArr) {
        return Arrays.stream(strArr).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] getSplit(String s) {
        return s.split(",|\n");
    }
}
