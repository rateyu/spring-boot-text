package com.ming.springboottext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Loop {
    public static void main(String[] args) {
        //拆分循环
        //一个循环执行2-3个事情 拆分为2-3个单独的循环

        //管道取代循环
//        String [] tmp = {"111","222","333"};
//        Arrays.stream(tmp).flatMap()
        List <String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("world2");
        list.add("world3");
        System.out.println(list.stream().filter(p -> ("hello".equals(p))).collect(Collectors.toList()));
        System.out.println(list.stream().map(p->p.substring(0,3)).collect(Collectors.toList()));

        List <User> userArrayList = new ArrayList<User>();
        User user1 = new User("aaa","aaaa",5);
        User user2 = new User("bbb","bbbb",5);
        User user3 = new User("ccc","cccc",5);
        User user4 = new User("ddd","dddd",5);
        User user5 = new User("中国","北京",5);
        User user6 = new User("你好","南京",5);

        userArrayList = Arrays.asList(user1, user2, user3, user4, user5, user6);


        Optional<List <User>> s = Optional.ofNullable(userArrayList);
        s.ifPresent(System.out::println);

        Optional<User> user = Optional.ofNullable(user1);
//        user.isPresent();

    }
}
