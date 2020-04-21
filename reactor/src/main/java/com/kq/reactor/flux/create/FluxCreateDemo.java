package com.kq.reactor.flux.create;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FluxCreateDemo {

    public static void main(String[] args) {
//        Flux<String> bridge = Flux.create(sink -> {
////            myEventProcessor.register(
//                    new MyEventListener<String>() {
//                        @Override
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//                        @Override
//                        public void processComplete() {
//                            sink.complete();
//                        }
////                    });
//        });
//        };

//        MyEventListener listener = new MyEventListener<String>(){
//            @Override
//            public void onDataChunk(List<String> chunk) {
//
//            }
//
//            @Override
//            public void processComplete() {
//
//            }
//        };

        Random random = new Random();
        MyEventProcessor processor = (listener)-> {
            for(int i=0;i<10;i++) {
                List<String> list = new ArrayList<>();
                list.add(random.nextInt(10)+"");
                list.add(random.nextInt(10)+"");
                listener.onDataChunk(list);
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        };


        Flux<String> flux = Flux.create(sink -> {
            processor.register(
                    new MyEventListener<String>() {
                        @Override
                        public void onDataChunk(List<String> chunk) {
                            for(String s : chunk) {
                                sink.next(s);
                            }
                        }
                        @Override
                        public void processComplete() {
                            sink.complete();
                        }
                    });
        });

        flux.subscribe(s-> System.out.println("str="+s));

    }
}
