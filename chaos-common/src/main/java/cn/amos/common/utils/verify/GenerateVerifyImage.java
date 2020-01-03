//package cn.amos.common.utils.verify;
//
//import com.google.code.kaptcha.impl.DefaultKaptcha;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Random;
//
///**
// * PROJECT: hello <br>
// * DESCRIPTION: 放在这个位置是无效的
// *
// * @author wangdaoyuan
// * @date 2018/8/29
// */
//@Component
//public class GenerateVerifyImage {
//
//    public static int LENGTH = 6;
//
//    private static final int DISTURBING_LINES = 4;
//
//    private static final int FONT_SIZE = 30;
//
//    private static final char[] CHARS = "ABCDEFGHJKMNPQRSTVWXYZ2356789".toCharArray();
//
//    private static final Random RANDOM = new Random();
//
//
//    @Resource
//    private DefaultKaptcha kaptcha;
//
//    /**
//     * 生成验证码
//     */
//    private static String initRandomCode() {
//        char[] chars = new char[LENGTH];
//        int index = 0;
//        while (index < LENGTH) {
//            chars[index++] = CHARS[RANDOM.nextInt(CHARS.length)];
//        }
//
//        return new String(chars);
//    }
//
//    /**
//     * 使用Google的工具类生成验证码图片
//     */
//    public void generatorByKaptcha(OutputStream output) throws IOException {
//        BufferedImage image = kaptcha.createImage(kaptcha.createText());
//
//        ImageIO.write(image, "PNG", output);
//
//        try {
//            image.flush();
//            output.flush();
//        } finally {
//            output.close();
//        }
//    }
//
//
//    /**
//     * 原生Java生成验证码图片
//     */
//    public void generator(OutputStream output) throws IOException {
//        int width = LENGTH * (FONT_SIZE + 2) + 10;
//        int height = FONT_SIZE + 10;
//
//        // 创建一个缓存图片对象
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        // 得到画笔对象
//        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
//        // 设置前景色
//        graphics2D.setColor(new Color(153, 168, 216));
//        // 使用前景色填充距形
//        graphics2D.fillRect(0, 0, width, height);
//
//        // 绘制干扰线
//        for (int i = 0; i < DISTURBING_LINES; i++) {
//            // 生成随机颜色
//            Color color = new Color(RANDOM.nextInt(256), RANDOM.nextInt(256), RANDOM.nextInt(256));
//            graphics2D.setColor(color);
//            // 画线
//            graphics2D.drawLine(RANDOM.nextInt(width / 2), RANDOM.nextInt(height), RANDOM.nextInt(width / 2) + width / 2, RANDOM.nextInt(height));
//        }
//
//        graphics2D.setColor(Color.WHITE);
//        // 设置字体
//        graphics2D.setFont(new Font("Cooper Std", Font.PLAIN, FONT_SIZE));
//
//        String randomCode = initRandomCode();
//
//        for (int i = 0; i < randomCode.length(); i++) {
//            // 画字符
//            graphics2D.drawString(randomCode.substring(i, i + 1), 8 + FONT_SIZE * i, height / 2 + FONT_SIZE / 2);
//        }
//
//        ImageIO.write(image, "PNG", output);
//
//        try {
//            image.flush();
//            output.flush();
//        } finally {
//            output.close();
//        }
//
//    }
//
//}