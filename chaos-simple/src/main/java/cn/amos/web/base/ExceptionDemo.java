package cn.amos.web.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote 异常 demo
 * @date 2018/1/31
 */
public class ExceptionDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionDemo.class);

    public static void main(String[] args) {
        System.out.println("=========================start 华丽丽的分割线===============================");
        // 推荐写法
        try {
            throw new Exception("hello");
        } catch (Exception e) {
            LOGGER.error("*****************失败", e);
        }
        System.out.println("=========================华丽丽的分割线===============================");
        // 这样能显示出错误信息
        try {
            throw new Exception("hello");
        } catch (Exception e) {
            LOGGER.error("*****************失败[{}]", e.getMessage());
        }
        System.out.println("=========================华丽丽的分割线===============================");
        // 这样显示不出错误信息
        try {
            throw new Exception("hello");
        } catch (Exception e) {
            LOGGER.error("*****************失败", e.getMessage());
        }
        System.out.println("=========================end 华丽丽的分割线===============================");

        // final 无条件执行
        try {
//            throw new Exception("啦啦啦");
            LOGGER.info("启动成功");
        } catch (Exception e) {
            LOGGER.error("有异常", e);
        } finally {
            LOGGER.info("关闭成功");
        }

    }
}
