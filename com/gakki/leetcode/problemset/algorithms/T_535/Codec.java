package com.gakki.leetcode.problemset.algorithms.T_535;

/**
 * https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 * @author wangxiaobin
 */
public class Codec {

    public static void main(String[] args) {
        Codec codec  = new Codec();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        codec.encode(longUrl);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return longUrl;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
