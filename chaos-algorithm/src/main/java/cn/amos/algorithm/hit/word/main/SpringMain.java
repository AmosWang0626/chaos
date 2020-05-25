package cn.amos.algorithm.hit.word.main;

import cn.amos.algorithm.hit.word.config.WordConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 模块名称: chaos
 * 模块描述: SpringMain
 *
 * @author amos.wang
 * @date 2020/5/25 15:45
 */
@ComponentScan("cn.amos.algorithm.hit.word")
public class SpringMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringMain.class);

        WordConfig wordConfig = context.getBean(WordConfig.class);
        System.out.println(wordConfig.getWords());
    }

}
