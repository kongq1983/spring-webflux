package com.kq.reactor.flux;

import reactor.core.publisher.Flux;

public class FluxRangeDemo {

    public static void main1(String[] args) {

//        Flux<Integer> flux = Flux.range(1, 10)
//                .log()
//                .take(3);
//        flux.subscribe();

        Flux<Integer> flux = Flux.range(1,10).log().take(3);
        flux.subscribe();
        flux.subscribe(i-> System.out.println("i="+i));

    }

    public static void main2(String[] args) {

        Flux<Integer> ints = Flux.range(1,5).map(i-> {
            if(i<=3){
                return i;
            }
            throw new RuntimeException("Got to 4");
        });

        // 会执行throwable代码
        ints.subscribe(i->{
            System.out.println("num="+i);
        },throwable -> {
            System.out.println("throwable="+throwable);
        });
    }


    public static void main3(String[] args) {
        Flux<Integer> ints = Flux.range(1, 4);
        // 会输出Done
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));

    }

    public static void main(String[] args) {
        // count <=10  会输出Done >10 会输出 1-10的数字
        Flux<Integer> ints = Flux.range(1, 8);
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(10));
    }

}
