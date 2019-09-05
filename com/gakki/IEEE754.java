package com.gakki;

/**
 * float和double的精度丢失
 * @author wangxb (O_o)??)
 * @date 2019-09-01
 */
public class IEEE754 {

    /* ieee 754 双精度常量 */
    private static final int NOR_LEN_64 = 64;
    private static final int M_LEN_64 = 52;
    private static final int E_LEN_64 = 11;

    /* ieee 754单精度常量*/
    private static final int NOR_LEN_32 = 32;
    private static final int M_LEN_32 = 23;
    private static final int E_LEN_32 = 8;


    public static void main(String[] args) {
        printBit(-9.0);
    }

    private static void printBit(double d) {
        System.out.println("##"+d);
        long l = Double.doubleToLongBits(d);
        String bits = Long.toBinaryString(l);
        int len = bits.length();
        System.out.println(bits+"#"+len);

        if (len != NOR_LEN_64){ // 正数默认0,len == 63
            bits = "0" + bits;
        }
        System.out.println("S[63]"+bits.charAt(0));
        System.out.println("E[62-52]"+bits.substring(1,1+E_LEN_64));
        System.out.println("M[51-0]"+bits.substring(NOR_LEN_64-M_LEN_64,NOR_LEN_64));
    }
}
