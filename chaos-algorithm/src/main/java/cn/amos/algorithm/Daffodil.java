package cn.amos.algorithm;

/**
 * PROJECT: chaos
 * DESCRIPTION: 水仙花数
 *
 * @author DaoYuanWang
 * @date 2018/7/25
 */
public class Daffodil {

    public static void main(String[] args) {
        System.out.println(getDaffodil(100, 999));
    }

    private static String getDaffodil(int begin, int end) {
        if (begin > end) {
            return null;
        }

        if (begin < 100 || end > 999) {
            return null;
        }

        StringBuilder sb = new StringBuilder("水仙花数: ");
        while (begin <= end) {
            int n1 = begin / 100;
            int n2 = (begin % 100) / 10;
            int n3 = begin % 10;
            int val = (int) (Math.pow(n1, 3)) + (int) (Math.pow(n2, 3)) + (int) (Math.pow(n3, 3));
            if (begin == val) {
                sb.append(val + " ");
            }

            begin++;
        }

        return sb.toString();
    }
}
