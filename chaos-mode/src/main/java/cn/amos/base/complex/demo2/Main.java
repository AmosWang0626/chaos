package cn.amos.base.complex.demo2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Main {
    public static void main(String[] args) {
        BaseShape instance = Factory.getInstance(args);
        if (instance != null) {
            System.out.println("area: " + instance.area());
            System.out.println("perimeter: " + instance.perimeter());
        }
    }
}

class Factory {
    static BaseShape getInstance(String... args) {
        if (args == null || args.length <= 0) {
            return null;
        }

        if (args.length == 1) {
            return new Cycle(Double.valueOf(args[0]));
        } else {
            return new Rectangle(Double.valueOf(args[0]), Double.valueOf(args[1]));
        }
    }
}