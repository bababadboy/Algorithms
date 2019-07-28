package com.gakki.basic.stream;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamEntityDemo {

    private static final String CHARS  = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int SIZE  = 500;
    private static final int NAME_LENGTH  = 5;

    public static void main(String[] args) {

        // 模拟Dao获取Entity数据
        List<DataEntiy> list = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; i++) {

            String name = randomName();
            DataEntiy d = new DataEntiy(i+1,name,new Random().nextInt(99)+1);
            list.add(d);
        }

        // stream流打印
        System.out.println("=========all===========");
        list.parallelStream().forEach(s-> System.out.println(s.toString()));


        /* map */
        // 1. 名字大写
        // 2. 把时间戳时间格式化成YYYY-MM-DD-hh-mm-ss格式
        List<DataEntiy> mlist = list.parallelStream().map(e->{
                    e.setName(e.getName().toUpperCase());
                    return e;
                }).map(e->{
                    e.setCreateTime(formatTime(e.getCreateTime()));
                    e.setUpdateTime(formatTime(e.getUpdateTime()));
                    return e;
        })
                .collect(Collectors.toList());
        System.out.println("=========map===========");
        mlist.parallelStream().forEach(s-> System.out.println(s.toString()));

        /* filter */
        // 只要age between 20-30
        List<DataEntiy> flist= mlist.parallelStream()
                .filter(e ->e.getAge()>=20 && e.getAge() <= 30)
                .collect(Collectors.toList());
        System.out.println("=========filter===========");

        flist.parallelStream().forEach(s -> System.out.println(s.toString()));

        /* sorted 注意不能使用parallerStream()!!! 因为并行排序后再拼起来排序结果是不对的!!! */
        // 按照id asc
        System.out.println("=========sorted===========");
        flist.stream().sorted(
                Comparator.comparing(DataEntiy::getId)

        ).forEach(s-> System.out.println(s.toString()));


    }

    private static String formatTime(String createTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(Long.parseLong(createTime));
        return sd;      // 时间戳转换成时间
    }

    private static String randomName() {
        StringBuilder name = new StringBuilder();
        Random random=new Random();
        for (int j = 0; j < NAME_LENGTH; j++) {
            name.append(CHARS.charAt(random.nextInt(CHARS.length()-1)));
        }
        return name.toString();
    }
}
