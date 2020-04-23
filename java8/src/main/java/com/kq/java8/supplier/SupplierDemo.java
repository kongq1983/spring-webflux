package com.kq.java8.supplier;

import com.kq.java8.entity.Employee;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());


        Employee employee2 = createEmployee(()->{
            Employee e = new Employee("10");
            return e;
        });

        Employee employee3 = createEmployee(Employee::new);
        Employee employee4 = createEmployee(()-> new Employee());

        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);

    }

    public static Employee createEmployee(Supplier<Employee> supplier) {
        return supplier.get();
    }

}
