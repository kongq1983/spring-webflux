package com.kq.java8.function;

import org.springframework.util.StringUtils;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<String,Boolean> photoCheckFunction = (str)-> {
//            return str.toLowerCase().matches("\\w+.[gif|jpg|jpeg|png]$");
//            return str.toLowerCase().matches("\\w+.[jpg]{1}$");
            return str.toLowerCase().matches("\\w+.(jpg|jpeg|png|gif)$");
        };

        boolean result = photoCheckFunction.apply("123abc.jpg");
        System.out.println("123abc.jpg is photo , result="+result);
        result = photoCheckFunction.apply("123abc.png");
        System.out.println("123abc.png is photo , result="+result);


        Function<String,Boolean> equalsFunction = StringUtils::isEmpty;

    }

}
