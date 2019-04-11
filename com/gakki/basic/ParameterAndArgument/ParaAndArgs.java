package com.gakki.basic.ParameterAndArgument;

import java.util.Arrays;

/**
 * @author wangxiaobin
 */
public class ParaAndArgs {
    public static void main(String[] args) {
        int a = 1;
        func(a);
        System.out.println("a is "+a);

        String s1 = "My";
        String s2 = "name";
        String s3 = "";
        strFunc(s1,s2,s3);
        System.out.println("s3 is"+s3);

        StringBuilder sb= new StringBuilder();
        sb.append("I'am");
        sbFunc(sb);
        System.out.println(sb.toString());

        int arr[] = {0,1,2,3};
        arrFunc(arr);
        System.out.println(Arrays.toString(arr));


    }

    private static void arrFunc(int[] arr) {
        arr[0] = 100;
    }

    private static void sbFunc(StringBuilder sb) {
        sb.append(" StringBuilder.");
    }

    private static void func(int a){
        a ++;
    }

    private static void strFunc(String s, String s2, String s1){
        s1= s2 + s;
    }


}
