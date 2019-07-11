package com.gakki;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-09
 * 数字转成中文汉字如（可忽略大写:贰==>二）：2，0101.01 => 贰万零壹佰零壹点零壹
 */
public class Num2String {

    static String[] CHN_NUMBER = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    static String[] CHN_UNIT = {"", "十", "百", "千","万"};          //单位

    //    static String[] CHN_UNIT = {"", "十", "百", "千"};          //权位
    //    static String[] CHN_UNIT_SECTION = {"", "万", "亿", "万亿"}; //节权位
    private String n;   // 阿拉伯数字

    public Num2String(String s) {
        this.n = s;
    }

    public Num2String(double a) {
        n = String.valueOf(a);
    }

    public String toZh() {

        int dotIdx = n.indexOf('.');
        int len = n.length();
        String l = n.substring(0,dotIdx);
        String r = n.substring(dotIdx+1,len);

        String res = null;

        // 处理小数点左边
        String lRes = filterLeft(l);
        // 处理小数点右边
        String rRes = filterRight(r);

        return rRes == null? lRes:lRes+"点"+rRes;
    }

    private String filterRight(String r) {
        int rLen = r.length();  // 恒等于2
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rLen; i++) {
            sb.append(CHN_NUMBER[Integer.parseInt(String.valueOf(r.charAt(i)))]);
        }

        return "零零".equals(sb.toString()) ? null:sb.toString();
    }

    private String filterLeft(String l) {

        int lLen = l.length();
        String res = null;

        if (lLen <= 4){ // 到千位，即四位数
            res = qian(l);
        }else if (lLen <= 8 ){
            // 提取万位及以上的位
            String wanAbove  = qian(l.substring(0,lLen - 4));
            String wanBlow = qian(l.substring(lLen-4));
            res = wanAbove + "万"+ wanBlow;
        }

        return res;
    }

    /**
     * 千位大写中文
     */
    private String qian(String l) {
        int lLen = l.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lLen; i++) {
            if (i == lLen -1 && "0".equals(String.valueOf(l.charAt(i)))){
                break;
            }
            sb.append(CHN_NUMBER[Integer.parseInt(String.valueOf(l.charAt(i)))]);
            if (l.charAt(i) != '0'){    // bug:201 => 两百零十一
                sb.append(CHN_UNIT[lLen -1 - i]);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        createArabicNum2Zh();
        String n = "201.00";
        Num2String num2String = new Num2String(n);
        System.out.println(n+"=>"+num2String.toZh());
        double n2 = 3101.99;
        System.out.println(n2+"=>"+new Num2String(n2).toZh());

        String n3 = "21399101.99";
        System.out.println(n3+"=>"+new Num2String(n3).toZh());

        String n4 = "20000001.99";
        System.out.println(n4+"=>"+new Num2String(n4).toZh());
    }
}
