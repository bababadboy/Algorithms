package com.gakki.leetcode;

/**
 * @author wangxiaobin
 */
public class UnixPath {
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

    private static String current = "./";
    private static String parent = "../";
    public static String simplifyPath(String path){
        String simplifiedPath = path;
        // 末尾处理
        if (!simplifiedPath.endsWith("/")){
            simplifiedPath += "/";
        }
        // 去掉current
        simplifiedPath = removeCurrent(simplifiedPath);
        // 去掉redundant slashed
        StringBuilder redundantBuilder = new StringBuilder("//");

        for (int len = 2; len < simplifiedPath.length(); len ++) {
            if (!simplifiedPath.contains(redundantBuilder.toString())){
                break;
            }
            while (simplifiedPath.contains(redundantBuilder.toString())){
                simplifiedPath = simplifiedPath.replaceAll(redundantBuilder.toString(),"/");
            }
            redundantBuilder.append("/");
        }

        // 处理parent
        int idx = simplifiedPath.indexOf(parent);
        while ( idx != -1){
            int cutFrom = idx - 3;
            if (cutFrom >= 0){
                String cutStr = simplifiedPath.substring(cutFrom,cutFrom+5);
                simplifiedPath = simplifiedPath.replaceAll(cutStr,"");
            }else { // 已经在根路径
                simplifiedPath = simplifiedPath.substring(3);
            }
            idx = simplifiedPath.indexOf(parent);
        }

        // 处理最后一个slash
        if (simplifiedPath.endsWith("/") && simplifiedPath.length() > 1){
            simplifiedPath = simplifiedPath.substring(0,simplifiedPath.length()-1);
        }
        return simplifiedPath;
    }

    private static String removeCurrent(String path) {
        int idx = path.indexOf(current);
        while (idx != -1){
            if (idx > 0 && path.charAt(idx - 1)!='.'){
                String left = path.substring(0,idx);
                String right = path.substring(idx+2);
                path = left+right;
                idx = path.indexOf(current,idx);
            } else{ // 是../
                idx = path.indexOf(current,idx+2);
            }
        }
        return path;
    }

    public static void main(String[] args) {
//        System.out.println(simplifyPath("/a/../../b/../c//.//"));
//        System.out.println(simplifyPath("/a//b////c/d//././/.."));
//        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/..."));
    }


}
