package com.gakki.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 键索引计数法
 * @author wangxiaobin
 */
public class KeyIndexCount {
    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>();
        Student[] students = new Student[13];
        stuList.add(new Student("Anderson",2));
        stuList.add(new Student("Brown",3));
        stuList.add(new Student("Davis",3));
        stuList.add(new Student("Garcia",4));
        stuList.add(new Student("Harris",1));
        stuList.add(new Student("Jackson",3));
        stuList.add(new Student("Jones",3));
        stuList.add(new Student("Martin",1));
        stuList.add(new Student("Martinez",2));
        stuList.add(new Student("Miller",2));
        stuList.add(new Student("Moore",1));
        stuList.add(new Student("Robinson",2));
        stuList.add(new Student("Smith",4));
        // 1. 统计键频次
        int R = 4;  // 一共有四组1,2,3,4
        int[] count = new int[R+1];     // 0,1,2,3,4
        for (Student s:stuList
             ) {
            count[s.getGoupNo()] ++;
        }

//        for (int i :count
//             ) {
//            System.out.print(i+" ");
//        }

        // 2. 频次转换成索引
        for (int i = 0; i < R; i ++) {
            count[i+1] += count[i];
//            System.out.println(count[i+1]);
        }

        // 3. 数据分类
        Student[] aux =  new Student[13];
        for (Student s: students
             ) {
            aux[count[s.getGoupNo()-1]] = s;
        }

        // 4. 回写
//        for (int i = 0 ; i < aux.length; i ++) {
//            students[i] = aux[i];
//        }//建议食用System.arraycopy
        System.arraycopy(aux,0,students,0,aux.length);
    }
}
