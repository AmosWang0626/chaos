package cn.amos.algorithm.string;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    private static String reverseString(String s) {
        char[] old = s.toCharArray();
        int len = old.length;

        char temp;
        for (int i = 0; i < len / 2; i++) {
            temp = old[i];
            old[i] = old[len - i - 1];
            old[len - i - 1] = temp;
        }

        return new String(old);
    }
}
