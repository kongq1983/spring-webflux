package com.kq.reactor.flux.create;

import java.util.List;

public interface MyEventListener <T> {

    void onDataChunk(List<T> chunk);
    void processComplete();

}
