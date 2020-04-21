package com.kq.webflux.thymeleaf;

@FunctionalInterface
public interface MyEventProcessor {

    public abstract void register(MyEventListener listener);

}
