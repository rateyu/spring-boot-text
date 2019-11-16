package com.ming.springboottext;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaStudy {
    @Test
    public static void main(String[] args) {
        List list = Arrays.asList("hello", "word", "你好", "世界");
        //初始版本
        list.stream().filter(str -> "hello".equals(str)).map(str -> str = "你好").forEach(str -> System.out.println(str));
        //最简洁版本
        list.stream().filter(str -> "hello".equals(str)).map(str -> str = "你好").forEach(System.out::println);

        //线程
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }).start();

        //lambda 实现接口
        Ilike ilike = (a) -> {
            System.out.println("实现接口" + a);
        };
        ilike.lambda(99);

        //TODO 断言使用
        //Assert.assertEquals(a,2);

        //TODO mock使用

    }

    interface Ilike {
        void lambda(int a);
    }
}
