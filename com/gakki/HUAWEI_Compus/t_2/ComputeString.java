package com.gakki.HUAWEI_Compus.t_2;

import com.gakki.Algroithms4th.chapter1.Stack;

/**
 * 利用 ( 2 + ( 4 * 5) * (2 *3))思想，构造vals和ops栈
 * @author wangxiaobin
 */
public class ComputeString {
    public static void main(String[] args) {
        String s = "2(ab3(AB)4(cd))";
        s = computeStr(s);
        System.out.println(s);
    }
    // 假设都是"()"无"[]""{}"
    private static String computeStr(String s) {
//        s= "("+s+")";

        Stack<String> vals = new Stack<>(); // 存储字符串
        Stack<Integer> nums = new Stack<>();    // 存储数组

        for (int i = 0; i < s.length(); i++) {
            // 把单个字符转成 String 类型以便统一
            char c = s.charAt(i);
            String str = "";
            str += c;

            if (str.equals("(")){
                // 如果是"("，入栈
                vals.push(str);
            }
            else if (str.compareTo("0") >= 0 && str.compareTo("9") <= 0){
                // str 是数字
                int n = Integer.parseInt(str);
                nums.push(n);
            }
            else if (str.compareTo("BaseA") >=0 && str.compareTo("z") <= 0){
                // str 是大小写字母
                vals.push(str);
            }
            else{
                // 遇到了"右边半个括号"：")"
                String val = "";
                int num = nums.pop();
                while (!vals.top().equals("(")){
                    val += vals.pop();
                }
                vals.pop(); // 把"("弹栈
                val = timesStr(num,val);
                vals.push(val);
            }
        }

        return vals.pop();

    }

    private static String timesStr(int num, String val) {
        StringBuilder sb = new StringBuilder(val);

        for (int i = 0; i < num - 1; i++) {
            sb.append(val);
        }
        return sb.toString();
    }

}
