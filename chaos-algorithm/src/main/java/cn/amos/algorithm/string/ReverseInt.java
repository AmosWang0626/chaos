package cn.amos.algorithm.string;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class ReverseInt {

    /**
     * 同样两种方法
     *
     * @see ReverseInt#reverse1(int) 本方法, 笨方法
     * @see ReverseInt#reverse2(int) 高效方法, 技巧型
     */
    public static void main(String[] args) {
        System.out.println(reverse2(-1536469));
    }

    private static int reverse1(int x) {
        int negative = x > 0 ? 1 : -1;
        String s = String.valueOf(x * negative);
        char[] old = s.toCharArray();
        int len = old.length;

        char temp;
        for (int i = 0; i < len / 2; i++) {
            temp = old[i];
            old[i] = old[len - i - 1];
            old[len - i - 1] = temp;
        }

        try {
            return Integer.valueOf(new String(old)) * negative;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int reverse2(int x) {
        int negative = x > 0 ? 1 : -1;

        long result = 0L;

        x *= negative;

        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        // return negative * (int) result;
        return negative * Long.valueOf(result).intValue();
    }
}
