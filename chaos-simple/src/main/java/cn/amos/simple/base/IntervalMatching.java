package cn.amos.simple.base;

import lombok.Data;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class IntervalMatching {

    public static void main(String[] args) {
        System.out.println(match(new Interval(10001, 10001), new Interval(5000, 10000)));
    }

    private static boolean match(Interval self, Interval target) {

        if (self.getMin() <= target.getMax() && self.getMax() >= target.getMin()) {
            return true;
        }

        return false;
    }

}

@Data
class Interval {
    private int min;
    private int max;

    Interval(int min, int max) {
        this.min = min;
        this.max = max;
    }
}