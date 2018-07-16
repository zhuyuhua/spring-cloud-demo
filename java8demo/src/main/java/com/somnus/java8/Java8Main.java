package com.somnus.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Main {

    public static void main(String[] args) {

        String[] arrayOfWords = {"Goodbye", "World"};

        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        streamOfWords.forEach(System.out::println);


    }
}
