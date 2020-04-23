package com.kq.reactor.flux.generate;

import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * generate只能调用1次
 */
public class FluxSimpleGenerateDemo {

    public static void main1(String[] args) {
        Flux.generate(sink-> {
            sink.next("hello");
            sink.complete();
        }).subscribe(System.out::print);
    }

    public static void main2(String[] args) {

        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3*state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        flux.subscribe(System.out::println);

    }

    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.out.println("state: " + state));


        flux.subscribe(System.out::println);
    }

}
