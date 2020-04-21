package com.kq.reactor.supplier;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierDemo {

    static final Supplier<ArrayList> LIST_SUPPLIER = ArrayList::new;

    public static void main(String[] args) {

        ArrayList list = LIST_SUPPLIER.get();
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list.size());

    }

}
