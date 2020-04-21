package com.kq.webflux.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/flux")
public class FluxController {

    @GetMapping("/createNumber")
    public Flux<Integer> findAll1() {

        Flux<Integer> flux = Flux.create(sink-> {
            for(int i=0;i<10;i++) {
                sink.next(i);
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }
//            sink.complete();
        });

        return flux;

    }


    static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
    static List<MyEventListener> list = new ArrayList<>();
    static AtomicLong atomicLong = new AtomicLong();


    static {
        Runnable runnable = () -> {
            Long num = atomicLong.getAndIncrement();
            System.out.println("runnable run it num="+num+" list.size="+list.size());
            list.stream().forEach(e->{
                System.out.println("------------start-----------------");
                e.onDataChunk(String.valueOf(num));
                System.out.println("------------e-n-d-----------------");
            });
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable,5,3,TimeUnit.SECONDS);
    }


    @GetMapping("/createNumber1")
    public Flux<String> createNumber1() {

        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 5)
                .map(i -> 10 + i)
                .publishOn(s)
                .map(i -> "value " + i);

        return flux;
    }



    @GetMapping("/listener")
    public Flux<String> listener() {

        Random random = new Random();
        MyEventProcessor processor = (listener)-> {
//            for(int i=0;i<10;i++) {
//
//                listener.onDataChunk(random.nextInt(10)+"");
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }

            list.add(listener);

        };


        Flux<String> flux = Flux.create(sink -> {
            processor.register(
                    new MyEventListener<String>() {
                        @Override
                        public void onDataChunk(String chunk) {
                            System.out.println("------------onDataChunk start-----------------");
//                            for(String s : chunk) {
                                sink.next(chunk);
                            System.out.println("------------onDataChunk end-----------------");
//                            }
                        }
                        @Override
                        public void processComplete() {
                            sink.complete();
                        }
                    });
        });

        return flux;

    }

}
