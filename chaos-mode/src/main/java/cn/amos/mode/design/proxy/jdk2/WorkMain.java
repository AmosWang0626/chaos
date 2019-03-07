package cn.amos.mode.design.proxy.jdk2;

import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class WorkMain {

    public static void main(String[] args1) {
        Work work = newInstance(new WorkJob());

        work.cooking("AAA", "BBB");
        System.out.println("==================================================================================================");
        work.write("China, State of ceremonies ?", "China has been a ceremonial state since ancient times.");
    }


    private static Work newInstance(Work work) {
        return (Work) Proxy.newProxyInstance(work.getClass().getClassLoader(), work.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(MessageFormat.format("Work method: {0}; args: {1} begin ...",
                            method.getName(), Arrays.toString(args)));

                    Object invoke = method.invoke(work, args);

                    System.out.println("finish!");
                    return invoke;
                });
    }

}
