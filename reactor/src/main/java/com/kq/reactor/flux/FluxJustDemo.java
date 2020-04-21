package com.kq.reactor.flux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxJustDemo {

    public static void main(String[] args) {

        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        List<String> iterable = Arrays.asList("foo1", "bar1", "foobar1");
        Flux<String> seq2 = Flux.fromIterable(iterable);

        seq1.subscribe(s-> System.out.println(s));
        seq2.subscribe(System.out::println);

    }

}
