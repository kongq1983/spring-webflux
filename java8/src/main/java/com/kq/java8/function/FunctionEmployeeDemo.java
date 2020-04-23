package com.kq.java8.function;

import com.kq.java8.entity.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionEmployeeDemo {

    public static void main(String[] args) {

        // 无构造函数 需要通过Supplier来实现
        Supplier<Employee> supplier = Employee::new;
        Employee noPara = supplier.get();
        System.out.println("noPara="+noPara);

        // 1个参数构造函数
        Function<String,Employee> oneParaFunction = (s) -> new Employee(s);
        Employee onePara = oneParaFunction.apply("1");
        System.out.println("onePara="+onePara);

        // 2个构造函数
        BiFunction<String,String,Employee> twoParaFunction = (id, name) -> new Employee(id,name);
        Employee twoPara = twoParaFunction.apply("2","two");
        System.out.println("twoPara="+twoPara);

        // 3个构造函数  2个以上需要自己扩展接口 ThreeFunction
        ThreeFunction<String,String,Integer,Employee> threeFunction = (id,name,age) -> new Employee(id,name,age);
        Employee threePara = threeFunction.apply("3","three",18);
        System.out.println("threePara="+threePara);

        // 4个构造函数 FourFunction
        FourFunction<String,String,Integer,String,Employee> fourFunction = (id,name,age,hobby) -> new Employee(id,name,age,hobby);
        Employee fourPara = fourFunction.apply("4","four",18,"football");
        System.out.println("fourPara="+fourPara);




    }


}
