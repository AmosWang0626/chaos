package cn.amos.common.simple.generic;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/10/23
 */
public class Main {

    public static void main(String[] args) {
        BaseGeneric<String> stringBaseGeneric = new BaseGeneric<>();
        System.out.println(stringBaseGeneric.hello("Hello World!"));

        System.out.println(BaseGeneric.hi("Hello World!"));
        System.out.println(BaseGeneric.hi(666666666));
    }
}
