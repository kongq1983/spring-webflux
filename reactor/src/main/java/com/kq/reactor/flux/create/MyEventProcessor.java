package com.kq.reactor.flux.create;

@FunctionalInterface
public interface MyEventProcessor {

    public abstract void register(MyEventListener listener);

}
