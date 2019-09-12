package com.gakki.leetcode;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wangxb (O_o)??)
 * @date 2019-09-10
 */
public class UnixPathByStack {
    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     *
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * path = "/a/../../b/../c//.//", => "/c"
     * path = "/a//b////c/d//././/..", => "/a/b/c"
     *
     * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
     *
     * Corner Cases:
     *
     * Did you consider the case where path =
     *
     *
     * "/../"?
     * In this case, you should return "/".
     * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
     * In this case, you should ignore redundant slashes and return "/home/foo".
     */
    public static String simplifyPath(String path) {
        String[] pathItems = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : pathItems) {
            if ("..".equals(item)){
                if (!stack.isEmpty()){
                    stack.pop();
                }else {
                    continue;
                }
            }
            else if (".".equals(item) || "".equals(item)){
                continue;
            }
            else {
                stack.push(item);
            }

        }

        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        for (String item : stack) {
            st.push(item);
        }
        for (String s : st) {
            sb.append("/");
            sb.append(s);
        }
        if("".equals(sb.toString())){
            return "/";
        }
        return sb.toString();
}

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
//        System.out.println(simplifyPath("/..."));
    }
}