package com.kq.reactor.flux.create;

import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class FluxSimpleCreateDemo {

    public static void main(String[] args) {
        Flux flux = Flux.create(sink-> {
            for(int i=0;i<10;i++) {
                sink.next(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(i==8){
                    sink.complete();
                }
            }
        });

        flux.subscribe(System.out::print);
    }

}
