package com.kq.java8.supplier;

import com.kq.java8.entity.Employee;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier.get());
    }

}
