package com.kq.reactor.flux.generate;

import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

/**
 * generate只能调用1次
 */
public class FluxSimpleGenerateDemo {

    public static void main(String[] args) {
        Flux.generate(sink-> {
            sink.next("hello");
//            for(int i=0;i<10;i++) {
//                sink.next(i);
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
            sink.complete();
        }).subscribe(System.out::print);
    }

}
