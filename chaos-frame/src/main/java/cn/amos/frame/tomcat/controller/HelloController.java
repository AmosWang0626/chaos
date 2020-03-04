package cn.amos.frame.tomcat.controller;

/**
 * DESCRIPTION: HelloController
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
public class HelloController {

    public String hello() {
        return "HelloController Method hello()";
    }

    public Integer sum(String num1, String num2) {
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

}
