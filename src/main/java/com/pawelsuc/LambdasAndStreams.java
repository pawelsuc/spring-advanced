package com.pawelsuc;

import org.apache.catalina.LifecycleState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasAndStreams {
//    funkcja
//    nazwa
    //    lista parametrów
    //    ciało funkcji
//    typ zwracany
//    (lista parametów) -> <ciało funkcji>


    public static void main(String[] args) {

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Informacja z osobnego wątku");
//            }
//        });
//        thread.start();
//        System.out.println("Informacja z metody main");

//        Thread thread = new Thread(() -> System.out.println("Informacja z osobnego wątku"));
//        thread.start();
//        System.out.println("Informacja z metody main");

        List<Integer> numbers = Arrays.asList(52, 17, 44, 98, 76, 12, 69, 2137, 8761);
//        wybrać elementy parzyste, pomnożyć je przez 2, zsumować i wyświetlić wynik

//        int result = 0;
//        for (int i : numbers) {
//            if (i % 2 == 0) {
//                result += i * 2;
//            }
//        }
////        System.out.println(result);

//        System.out.println(numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .mapToInt(i -> i * 2)
//                .sum()
//                );
//        System.out.println(numbers.stream().reduce(0,(subtotal, element) -> subtotal + element));
        List<Integer> collect = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);


    }
}
