package com.kq.webflux.thymeleaf;

import java.util.List;

public interface MyEventListener <T> {

    void onDataChunk(T chunk);
    void processComplete();

}
