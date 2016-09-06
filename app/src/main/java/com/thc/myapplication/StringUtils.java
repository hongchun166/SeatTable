package com.thc.myapplication;

import java.util.Random;

/**
 * Created by THC on 2016/9/5.
 */
public class StringUtils {
    static Random random=new Random();
    private static char[] chars = new char[] { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    /**
     * 取随机的字符串
     * @return
     */
    public static String getRandomString(int length) {
        char[] r = new char[length];
        for (int i = 0; i < r.length; i++) {
            r[i] = chars[random.nextInt(chars.length)];
        }
        return String.valueOf(r);
    }
}
