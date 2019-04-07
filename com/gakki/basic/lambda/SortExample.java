package com.gakki.basic.lambda;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @author wangxiaobin
 */
public class SortExample {

    public static void main(String[] args) {
        String[] names ={"Stephn Curry","Jhon Wall","ZhuiMon Green","Cai Xukun"};


        // 使用匿名函数实现Comparator
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] tokensO1 = o1.split(" ");
                String[] tokensO2 = o2.split(" ");
                return tokensO1[1].compareTo(tokensO2[1]);
            }
        });

        System.out.println(Arrays.toString(names));

        // 使用lambda表达式实现Comparator
        Arrays.sort(names,(String o1, String o2) -> o1.compareTo(o2));
        System.out.println(Arrays.toString(names));


    }


    class NBAPlayer{
        private String firstName;
        private String lastName;

        public NBAPlayer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}

