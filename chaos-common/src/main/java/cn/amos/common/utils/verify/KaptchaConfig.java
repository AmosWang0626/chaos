//package cn.amos.common.utils.verify;
//
//import com.google.code.kaptcha.impl.DefaultKaptcha;
//import com.google.code.kaptcha.util.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
///**
// * PROJECT: hello
// * DESCRIPTION: 放在这个位置是无效的
// *
// * @author wangdaoyuan
// * @date 2018/8/29
// */
//@Configuration
//public class KaptchaConfig {
//
//    @Bean(name = "kaptcha")
//    public DefaultKaptcha getKaptcha() {
//        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
//        Properties properties = new Properties();
//        properties.setProperty("kaptcha.border", "yes");
//        properties.setProperty("kaptcha.border.color", "105,179,90");
//        properties.setProperty("kaptcha.textproducer.font.color", "blue");
//        properties.setProperty("kaptcha.image.width", "250");
//        properties.setProperty("kaptcha.image.height", "90");
//        properties.setProperty("kaptcha.session.key", "code");
//        properties.setProperty("kaptcha.textproducer.char.length", "4");
//        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
//
//        Config config = new Config(properties);
//        defaultKaptcha.setConfig(config);
//
//        return defaultKaptcha;
//    }
//}
