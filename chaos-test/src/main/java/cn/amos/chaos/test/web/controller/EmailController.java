package cn.amos.chaos.test.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * DESCRIPTION: 邮件工具类
 *
 * @author amos.wang
 * @date 2019/8/15
 */
@RequestMapping("email")
@RestController
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);

    @Resource
    private JavaMailSender javaMailSender;

    @GetMapping("text")
    public String text() {
        // 纯文本邮件对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("1833063210@qq.com");
        mailMessage.setTo("amos.wang@xiaoi.com");
        mailMessage.setSubject("amos");
        mailMessage.setText("Hello World!");

        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            LOGGER.error("发送 TEXT 邮件时发生异常! [{}]", e.getMessage());
            return "发送 TEXT 邮件时发生异常!";
        }
        return "TEXT 邮件已经发送";
    }

    @GetMapping("html/{message}")
    public String html(@PathVariable("message") String message) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("1833063210@qq.com");
            helper.setTo("amos.wang@xiaoi.com");
            helper.setSubject("amos");
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            sb.append("<head><title>amos-email</title></head>");
            sb.append("<body>");
            sb.append("<h1>Hello Email!</h1>");
            sb.append("<p>");
            sb.append(message);
            sb.append("</p>");
            sb.append("<img src='http://mail.xiaoi.com/cgi-bin/viewfile?type=skin&domain=xiaoi.com&f=14217A43806E5DEC86A3C8CFDFEBD897573EEC08654AF00962F7F323BDFC4020&skin_modtime=1571125527'>");
            sb.append("</body>");
            sb.append("</html>");
            helper.setText(sb.toString(), true);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            LOGGER.error("发送 HTML 邮件时发生异常! [{}]", e.getMessage());
            return "发送 HTML 邮件时发生异常!";
        }
        return "HTML 邮件已经发送";
    }

}
