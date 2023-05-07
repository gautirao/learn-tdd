package com.goutham.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AcronymGenerator {
    public String generate(String fullName) {

        if (fullName.isBlank()) {
            return "";
        }

        String[] names = splitBySpaceAndHypen(fullName);
        List<String> namesList = Arrays.asList(names);

        return namesList.stream()
                .map(upperCaseExceptVon())
                .map(this::getInitial)
                .collect(Collectors.joining());

    }

    private static String[] splitBySpaceAndHypen(String fullName) {
        return fullName.split("[-\\s]");
    }

    private static Function<String, String> upperCaseExceptVon() {
        return name -> name.equals("von") ? name : name.toUpperCase();
    }

    private String getInitial(String name) {
        return name.substring(0, 1);
    }
}
