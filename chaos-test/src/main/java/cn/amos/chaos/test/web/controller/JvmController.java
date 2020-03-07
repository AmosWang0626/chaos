package cn.amos.chaos.test.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * DESCRIPTION: JvmTestController
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/6/2020
 */
@RestController
@RequestMapping("jvm")
public class JvmController {

    private boolean closeFlag = true;


    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("jump")
    public String jump() {
        closeFlag = !closeFlag;
        return "循环状态 ？" + (closeFlag ? "关闭" : "打开");
    }

    @GetMapping("range")
    public String range() {
        while (true) {
            if (closeFlag) {
                break;
            }
            if (System.currentTimeMillis() % 1000 == 0) {
                System.out.println(Thread.currentThread());
            }
        }
        System.out.println("\n\n");
        return "已退出循环";
    }

    @GetMapping("hex")
    public String getHex(@RequestParam("num") Integer num) {
        return Integer.toHexString(num).toUpperCase();
    }

    @GetMapping("decimal")
    public Integer getDecimal(@RequestParam("hex") String hex) {
        return Integer.parseInt(hex, 16);
    }

}
